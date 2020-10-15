package facilities;

import vehicles.Vehicle;

import java.util.concurrent.Semaphore;

//4
public class FuelStation {
    private static final float FULL_STORAGE = 1000000f;
    private static final long FILL_UP_TIME = 5000L;
    private float storage;

    public FuelStation() {
        storage = FULL_STORAGE;
    }

    public float getStorage() {
        return storage;
    }

    public void fillUp(Vehicle vehicle) throws InterruptedException{
        //5
        Semaphore semaphore = new Semaphore(3, true);
        semaphore.acquire();
        try{
            synchronized (this) {
                Thread.sleep(FILL_UP_TIME);
                System.out.println(vehicle.getRegistrationPlate() + " is filling up");
                storage -= vehicle.getTankCapacity();
            }
        } catch (InterruptedException e){
            throw new InterruptedException("exception inside synchronized block");
        } finally {
            semaphore.release();
        }
        vehicle.fillUp();
    }

    public float fillUp(float amount) throws InterruptedException{
        //5
        Semaphore semaphore = new Semaphore(3, true);
        semaphore.acquire();
        try{
            synchronized (this) {
                Thread.sleep(FILL_UP_TIME);
                storage -= amount;
            }
        } catch (InterruptedException e){
            throw new InterruptedException("exception inside synchronized block");
        } finally {
            semaphore.release();
        }
        return amount;
    }
}
