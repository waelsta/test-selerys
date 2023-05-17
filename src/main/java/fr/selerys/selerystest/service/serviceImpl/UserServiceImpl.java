package fr.selerys.selerystest.service.serviceImpl;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.User;
import fr.selerys.selerystest.model.WheatherStation;
import fr.selerys.selerystest.repository.UserRepository;
import fr.selerys.selerystest.repository.WheatherStationRepository;
import fr.selerys.selerystest.service.UserService;
import fr.selerys.selerystest.utils.DistanceCalculations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WheatherStationRepository wheatherStationRepository;
    @Override
    public User updatePosition(long userId, double latitude, double longitude) {
        try{
            User DBUser = userRepository.findById(userId).get();
            DBUser.setLongitude(longitude);
            DBUser.setLatitude(latitude);
            userRepository.save(DBUser);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public WheatherStation ActivateNearestStation(User user) {
        try{
            Client client = user.getClient();
            Set<WheatherStation>  availableWheatherStations = client.getWheatherStations();
            WheatherStation closestStation = DistanceCalculations.findNearestStationFromUser(availableWheatherStations,user.getLatitude(),user.getLongitude());
            if(!closestStation.isActive()){
                closestStation.setActive(true);
                wheatherStationRepository.save(closestStation);
            }
            return closestStation;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
