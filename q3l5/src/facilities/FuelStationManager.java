package facilities;

public final class FuelStationManager {
    private static final int MAX_STATIONS = 1;
    private final FuelStation[] stations = new FuelStation[MAX_STATIONS];

    private static FuelStationManager instance;

    private FuelStationManager() {
        stations[0] = new FuelStation();
    }

    public static FuelStationManager getInstance(){
        if (instance == null){
            instance = new FuelStationManager();
        }
        return instance;
    }

    public FuelStation getFuelStation(){
        //Simple implementation
        return stations[0];
    }
}
