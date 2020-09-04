import com.geekbrains.java.course.threads.ArrayCalc;
import com.geekbrains.java.course.utils.ArrayInit;

public class Main {

    private static ArrayInit arrayInit = new ArrayInit();

    public static void main(String[] args) throws InterruptedException{

        calcFull();

        calcInParts();

    }

    public static void calcFull() throws InterruptedException{
        ArrayCalc arrayCalc1 = new ArrayCalc(arrayInit.getArray());

        long startTime = System.currentTimeMillis();
        Thread thread = new Thread(arrayCalc1);
        thread.start();
        thread.join();

        System.out.println("Single: " + (System.currentTimeMillis() - startTime));
    }

    public static void calcInParts() throws InterruptedException{
        long startTime = System.currentTimeMillis();

        ArrayCalc arrayCalc2_1 = new ArrayCalc(arrayInit.getArrayPart(0));
        ArrayCalc arrayCalc2_2 = new ArrayCalc(arrayInit.getArrayPart(1));

        Thread thread1 = new Thread(arrayCalc2_1);
        Thread thread2 = new Thread(arrayCalc2_2);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Parralel: " + (System.currentTimeMillis() - startTime));
    }
}
