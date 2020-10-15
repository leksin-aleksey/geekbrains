import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //3
        LinkedList<Vehicle> vehicles = new LinkedList<>();

        Car car1 = new Car("Car01");
        Car car2 = new Car("Car02");
        Car car3 = new Car("Car03");
        Car car4 = new Car("Car04");

        Truck truck1 = new Truck("Truck01");
        Truck truck2 = new Truck("Truck02");
        Truck truck3 = new Truck("Truck03");

        Bus bus1 = new Bus("Bus1");
        Bus bus2 = new Bus("Bus2");
        Bus bus3 = new Bus("Bus3");
        Bus bus4 = new Bus("Bus4");

        vehicles.add(car1);
        vehicles.add(car2);
        vehicles.add(car3);
        vehicles.add(car4);
        vehicles.add(truck1);
        vehicles.add(truck2);
        vehicles.add(truck3);
        vehicles.add(bus1);
        vehicles.add(bus2);
        vehicles.add(bus3);
        vehicles.add(bus4);

        for(Vehicle vehicle : vehicles){
            Thread thread = new Thread(vehicle);
            thread.start();
        }
    }
}
