import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private Map<Integer, CheckIn> checkInMap;
    private Map<String, Route> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.remove(id);

        String key = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        Route route = travelMap.getOrDefault(key, new Route());
        route.totalTime += travelTime;
        route.count++;
        travelMap.put(key, route);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        Route route = travelMap.get(key);
        return (double) route.totalTime / route.count;
    }

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int totalTime = 0;
        int count = 0;
    }
}
