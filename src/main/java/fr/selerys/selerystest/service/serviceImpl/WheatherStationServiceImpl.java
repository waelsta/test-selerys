package fr.selerys.selerystest.service.serviceImpl;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.WheatherStation;
import fr.selerys.selerystest.repository.WheatherStationRepository;
import fr.selerys.selerystest.service.WheatherStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WheatherStationServiceImpl implements WheatherStationService {

    private final WheatherStationRepository wheatherStationRepository;
    @Override
    public List<WheatherStation> findAllStations() {
        try{
            return wheatherStationRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
     public WheatherStation findStationByCoordinates(double longitude, double latitude){
        try{
            return wheatherStationRepository.findFirstByLatitudeAndLongitude(longitude,latitude);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

     public String removeStation(long stationId){
        try{
            wheatherStationRepository.deleteById(stationId);
            return "successfully deleted !";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "couldn't delete station :(";
    }

    @Override
    public WheatherStation findStationById(long stationId) {
        try{
            return wheatherStationRepository.findById(stationId).get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WheatherStation addNewClient(Client client, long stationId) {
        try{
            WheatherStation DBStation = wheatherStationRepository.findById(stationId).get();
            DBStation.getClients().add(client);
            return wheatherStationRepository.save(DBStation);
        }catch(Exception e){
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public WheatherStation toggleStationState(long stationId) {
        try{
            WheatherStation DBStation = wheatherStationRepository.findById(stationId).get();
            DBStation.setActive(!DBStation.isActive());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public String updateStation(WheatherStation wheatherStation){
        try{
            WheatherStation DBwheatherStation = wheatherStationRepository.findById(wheatherStation.getId()).get();
            DBwheatherStation.builder()
                    .longitude(wheatherStation.getLongitude())
                    .latitude(wheatherStation.getLatitude())
                    .name(wheatherStation.getName())
                    .purpose(wheatherStation.getPurpose())
                    .clients(wheatherStation.getClients())
                    .isActive(wheatherStation.isActive())
                    .build();
             wheatherStationRepository.save(DBwheatherStation);
             return "station updated successfully";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "failed to update station";
    }

    public WheatherStation createStation(WheatherStation wheatherStation){
        try{
           return wheatherStationRepository.save(wheatherStation);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
