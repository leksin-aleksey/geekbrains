package ru.geekbrains.java.api.test;

import ru.geekbrains.java.tests.CustomTest1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestRunner {
    private static Method methodBeforeSuite;
    private static Method methodAfterSuite;

    private static Map<Integer, List<Method>> methodsOrder = new TreeMap<>();

    public static void main(String[] args) throws Exception{
//        CustomTest1 test1 = new CustomTest1();
        start(CustomTest1.class);
    }

    private TestRunner() {}

    public static void start(Class<?> clazz) throws Exception{
        Constructor<?> constructor = clazz.getConstructor();
        Object object = constructor.newInstance();
        checkMethodExistanceOnceAsMax(object, BeforeSuite.class);
        checkMethodExistanceOnceAsMax(object, AfterSuite.class);
        collectMethods(object);
        runMethods(object);
    }

    public static void start(String className) throws Exception{
        Class<?> clazz = Class.forName(className);
        start(clazz);
    }

    private static void checkMethodExistanceOnceAsMax(Object object, Class<? extends Annotation> annotation){
        boolean isExisted = false;
        for (Method method : object.getClass().getMethods()){
            for (Annotation a : method.getDeclaredAnnotations()){
                if (a.annotationType() == annotation){
                    if (isExisted){
                        throw new RuntimeException(
                                String.format("%s annotation must be used once as max",
                                        annotation.getName()));
                    }
                    isExisted = true;
                    break;
                }
            }
        }
    }

    private static void collectMethods(Object object){
        for (Method method : object.getClass().getMethods()) {
            for (Annotation a : method.getDeclaredAnnotations()) {
                if (a.annotationType() == BeforeSuite.class){
                    methodBeforeSuite = method;
                } else if (a.annotationType() == AfterSuite.class){
                    methodAfterSuite = method;
                } else if (a.annotationType() == Test.class){
                    /*TODO test method order*/
                    List<Method> list;
                    if (!methodsOrder.containsKey(1)){
                        list = new LinkedList<>();
                    } else {
                        list = methodsOrder.get(1);
                    }
                    list.add(method);
                    methodsOrder.put(1, list);
                }
            }
        }
    }

    private static void runMethods(Object object) throws Exception{
        if (methodBeforeSuite != null){
            /*TODO parameters*/
            methodBeforeSuite.invoke(object, "");
        }

        for (Map.Entry<Integer, List<Method>> entry : methodsOrder.entrySet()){
            /*TODO parameters*/
            for(Method method : entry.getValue()){
                method.invoke(object);
            }
        }

        if (methodAfterSuite != null){
            /*TODO parameters*/
            methodAfterSuite.invoke(object,"");
        }
    }
}
