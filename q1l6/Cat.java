public class Cat extends Animal {
    //1
    public Cat(String name, String color, int age) {
        super(name, color, age);
        System.out.println("Child constructor");
    }

//    @Override
//    public void move(int len) {
//        System.out.println(String.format("Cat[%s] is moving...", super.name));
//    }

//    @Override
//    public void swim(int len) {
//
//    }
//
//    @Override
//    public void jump(int len) {
//
//    }

    public void printInfo() {
        System.out.println(String.format("Cat: Name - %s, Color = %s, Age - %s", super.name, super.color, super.age));
    }

    public void meow() {
        System.out.println(String.format("Cat[%s] is meowing...", super.name));
    }

}
