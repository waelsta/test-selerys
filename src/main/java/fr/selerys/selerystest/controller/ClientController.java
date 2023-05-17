package fr.selerys.selerystest.controller;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.User;
import fr.selerys.selerystest.model.WheatherStation;
import fr.selerys.selerystest.service.serviceImpl.ClientServiceImpl;
import fr.selerys.selerystest.service.serviceImpl.WheatherStationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientServiceImpl clientService;


    @GetMapping
    private List<Client> getAllClients(){
        return clientService.findAllClients();
    }

    @GetMapping
    private Client getClientById(@RequestParam(name = "clientId") long clientId){
        return clientService.findClientByid(clientId);
    }

    @PostMapping
    private Client createClient(Client client){
        return clientService.createClient(client);
    }

    @DeleteMapping
    private String deleteClient(Client client){
        return clientService.removeClient(client.getId());
    }

    @PutMapping
    private String updateClient(Client client){
        return clientService.updateClient(client);
    }

    @PostMapping("/clients/add")
    private Client addNewClientToStation(User user, @RequestParam(name = "clientId") long clientId){
        return clientService.addNewUser(user,clientId);
    }
}
