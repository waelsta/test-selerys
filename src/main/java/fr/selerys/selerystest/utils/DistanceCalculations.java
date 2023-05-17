package fr.selerys.selerystest.utils;

import fr.selerys.selerystest.model.WheatherStation;

import java.util.Set;

public class DistanceCalculations {
    public static WheatherStation findNearestStationFromUser(Set<WheatherStation> stations, double userLatitude, double userLongitude){

        WheatherStation closestStation = stations.stream().findFirst().get();
        double closestCoordinates = Math.abs(Math.abs(
                stations.stream().findFirst().get().getLatitude()- userLatitude)
                - Math.abs(stations.stream().findFirst().get().getLongitude() - userLongitude));

        for(WheatherStation station : stations){
            double currentCoordinates = Math.abs(Math.abs(station.getLatitude() - userLatitude) - Math.abs(station.getLongitude() - userLongitude));
            if(currentCoordinates < closestCoordinates){
                closestCoordinates = currentCoordinates;
                closestStation = station;
            }
        }
        return closestStation;
    }
}
