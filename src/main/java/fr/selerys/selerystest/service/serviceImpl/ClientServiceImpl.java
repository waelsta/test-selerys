package fr.selerys.selerystest.service.serviceImpl;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.User;
import fr.selerys.selerystest.model.WheatherStation;
import fr.selerys.selerystest.repository.ClientRepository;
import fr.selerys.selerystest.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public List<Client> findAllClients() {
        try{
            return clientRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client createClient(Client client) {
        try{
            return clientRepository.save(client);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String updateClient(Client client) {
        try{
            Client DBClient = clientRepository.findById(client.getId()).get();
            DBClient.builder()
                    .name(client.getName())
                    .email(client.getEmail())
                    .users(client.getUsers())
                    .build();
            clientRepository.save(DBClient);
            return "client updated successfully";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "failed to update client";
    }

    @Override
    public String removeClient(long clientId) {
        try{
            clientRepository.deleteById(clientId);
            return "client successfully deleted !";
        }catch(Exception e){
            e.printStackTrace();
        }
        return "couldn't delete client :(";
    }

    @Override
    public Client findClientByid(long clientId) {
        try{
            return clientRepository.findById(clientId).get();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client addNewUser(User user, long clientId) {
        try {
            Client DBClient = clientRepository.findById(clientId).get();
            DBClient.getUsers().add(user);
            return clientRepository.save(DBClient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
