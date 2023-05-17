package fr.selerys.selerystest.service;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.User;
import fr.selerys.selerystest.model.WheatherStation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    List<Client> findAllClients();

    Client createClient(Client client);

    String updateClient(Client client);

    String removeClient(long clientId);

    Client findClientByid(long clientId);

    Client addNewUser(User user, long clientId);

}
