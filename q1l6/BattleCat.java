public class BattleCat extends Cat {
    private int serialNumber;

    public BattleCat(String name, String color, int age, int serialNumber) {
        super(name, color, age);
        this.serialNumber = serialNumber;
    }

//    @Override
//    public void move(int len) {
//        System.out.println(String.format("BattleCat[#%s][%s] is moving...", serialNumber, super.name));
//    }

//    @Override
//    public void swim(int len) {
//        super.swim(len);
//    }
//
//    @Override
//    public void jump(int len) {
//        super.jump(len);
//    }
}
