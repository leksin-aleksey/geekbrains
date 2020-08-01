import java.util.Random;

public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;

    //3
    private final int moveLimit, swimLimit, jumpLimit;

    public Animal(String name, String color, int age) {
        System.out.println("Parent constructor");
        this.name = name;
        this.color = color;
        this.age = age;

        //5
        Random random = new Random();
        moveLimit = random.nextInt(1000);
        swimLimit = random.nextInt(500);
        jumpLimit = random.nextInt(100);
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    //2
    public void move(int len){
        //4
        System.out.println(String.format("move(%d/%d): %s", len, moveLimit, len <= moveLimit ? "true" : "false"));
    }
    //2
    public void swim(int len){
        //4
        System.out.println(String.format("swim(%d/%d): %s", len, swimLimit, len <= swimLimit ? "true" : "false"));
    }
    //2
    public void jump(int len){
        //4
        System.out.println(String.format("jump(%d/%d): %s", len, jumpLimit, len <= jumpLimit ? "true" : "false"));
    }
}
