package vehicles;

//1
public abstract class Vehicle implements Runnable{

    public abstract String getRegistrationPlate();

    public abstract float getFuelLevel();

    public abstract float getTankCapacity();

    public abstract float getMPG();

    public abstract void fillUp();

    public abstract void fullTank();

    public abstract void drive();
}
