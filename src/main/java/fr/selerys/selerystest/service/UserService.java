package fr.selerys.selerystest.service;

import fr.selerys.selerystest.model.User;
import fr.selerys.selerystest.model.WheatherStation;

public interface UserService {

    User updatePosition(long userId, double latitude, double longitude);

    WheatherStation ActivateNearestStation(User user);
}
