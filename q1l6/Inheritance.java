public class Inheritance {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Kitty", "Blue", 4),
                new Dog("Puppy", "Red", 14),
                new BattleCat("Mabari", "White", 9, 123)
        };

        Animal hidden = new Cat("Kitty", "Blue", 4);
        hidden.move(10);


        Cat cat = new Cat("Kitty", "Blue", 4);
        System.out.println(cat.getAge());
        System.out.println(cat.getName());
        cat.printInfo();
        cat.meow();
        cat.move(100);

        BattleCat battleCat = new BattleCat("Mabari", "White", 9, 123);
        battleCat.move(30);

        Dog dog = new Dog("Puppy", "Red", 14);
        dog.move(900);
        dog.swim(400);
        dog.jump(200);
    }
}
