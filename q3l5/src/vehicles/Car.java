package vehicles;

import facilities.FuelStation;
import facilities.FuelStationManager;

public class Car extends Vehicle{
    private static final float TANK_CAPACITY_DEFAULT = 20f;
    private static final float MPG_DEFAULT = 2.5f;

    private final String registrationPlate;

    private float fuelLevel;
    private final float tankCapacity;
    private final float mpg;

    public Car(String registrationPlate) {
        this.registrationPlate = registrationPlate;
        tankCapacity = TANK_CAPACITY_DEFAULT;
        mpg = MPG_DEFAULT;
        fuelLevel = tankCapacity;
    }

    public Car(String registrationPlate, float tankCapacity, float mpg) {
        this.registrationPlate = registrationPlate;
        this.tankCapacity = tankCapacity;
        this.mpg = mpg;
        fuelLevel = this.tankCapacity;
    }

    @Override
    public void run() {
        while (true){
            //6
            System.out.println(getRegistrationPlate() + " is driving");
            drive();
            if(getFuelLevel() == 0){
                System.out.printf("%s is filling up%n", registrationPlate);
                fillUp();
            }
        }
    }

    @Override
    public String getRegistrationPlate() {
        return registrationPlate;
    }

    @Override
    public float getFuelLevel() {
        return fuelLevel;
    }

    @Override
    public float getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public float getMPG() {
        return mpg;
    }

    @Override
    public void fillUp() {
        FuelStation fuelStation = FuelStationManager.getInstance().getFuelStation();
        try {
            fuelLevel += fuelStation.fillUp(tankCapacity - fuelLevel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fullTank() {
        fuelLevel = tankCapacity;
    }

    @Override
    public void drive() {
        try {
            //2
            Thread.sleep(3000L);
            fuelLevel = Math.max(fuelLevel - MPG_DEFAULT, 0);
            System.out.printf("%s fuel level: %f%n", getRegistrationPlate(), getFuelLevel());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
