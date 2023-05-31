class UndergroundSystem {
    HashMap<Integer,Pair<String,Integer>> checkInMap;
    HashMap<String,Pair<Integer,Integer>> travelMap;
    public UndergroundSystem() {
        checkInMap=new HashMap<>();
        travelMap=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id,new Pair(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p=checkInMap.remove(id);
        String startStation=(String)p.getKey();
        int startTime=(Integer)p.getValue();
        String routeKey=stationKey(startStation,stationName);
        int totalTime=0;
        int travels=0;

        Pair timeTravelPair=travelMap.getOrDefault(routeKey,new Pair(totalTime,travels));
        totalTime=(Integer)timeTravelPair.getKey();
        totalTime+=(t-startTime);
        travels=(Integer)timeTravelPair.getValue()+1;


        travelMap.put(routeKey,new Pair(totalTime,travels));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey=stationKey(startStation,endStation);
        Pair timeTravelPair=travelMap.get(routeKey);
        double time=(Integer)timeTravelPair.getKey();
        int travels=(Integer)timeTravelPair.getValue();

        return time/(1.0*travels);
    }

    private String stationKey(String startStation, String endStation)
    {
        return startStation+"->"+endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */