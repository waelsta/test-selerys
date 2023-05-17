package fr.selerys.selerystest.service;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.WheatherStation;
import fr.selerys.selerystest.repository.WheatherStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WheatherStationService {
    List<WheatherStation> findAllStations();

    WheatherStation createStation(WheatherStation wheatherStation);

    WheatherStation findStationByCoordinates(double latitude, double longitude);

    String updateStation(WheatherStation wheatherStation);

    String removeStation(long stationId);

    WheatherStation findStationById(long stationId);

    WheatherStation addNewClient(Client client, long stationId);

    WheatherStation toggleStationState(long stationId);
}
