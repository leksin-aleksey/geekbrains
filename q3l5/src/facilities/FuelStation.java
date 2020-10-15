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
        synchronized (this) {
            Thread.sleep(FILL_UP_TIME);
            storage -= vehicle.getTankCapacity();
        }
        semaphore.release();
        vehicle.fillUp();
    }
}
