package fr.selerys.selerystest.controller;

import fr.selerys.selerystest.model.Client;
import fr.selerys.selerystest.model.WheatherStation;
import fr.selerys.selerystest.repository.WheatherStationRepository;
import fr.selerys.selerystest.service.WheatherStationService;
import fr.selerys.selerystest.service.serviceImpl.WheatherStationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
@RequiredArgsConstructor
public class WheatherStationController {

    private final WheatherStationServiceImpl wheatherStationService;

    @GetMapping
    private List<WheatherStation> getAllStations(){
        return wheatherStationService.findAllStations();
    }

    @GetMapping
    private WheatherStation getStationByCoordinates(double latitude, double longitude){
        return wheatherStationService.findStationByCoordinates(latitude, longitude);
    }

    @GetMapping
    private WheatherStation getStationById(@RequestParam(name = "stationId") long stationId){
        return wheatherStationService.findStationByid(stationId);
    }

    @PostMapping
    private WheatherStation createStation(WheatherStation wheatherStation){
        return wheatherStationService.createStation(wheatherStation);
    }

    @DeleteMapping
    private String deleteStation(WheatherStation wheatherStation){
        return wheatherStationService.removeStation(wheatherStation.getId());
    }

    @PutMapping
    private String updateStation(WheatherStation wheatherStation){
        return wheatherStationService.updateStation(wheatherStation);
    }

    @PostMapping("/clients/add")
    private WheatherStation addNewClientToStation(Client client,@RequestParam(name = "stationId") long stationId){
        return wheatherStationService.addNewClient(client,stationId);
    }

    @PutMapping("/update/state")
    private WheatherStation toggleStationState(@RequestParam(name="stationId") long stationId){
        return wheatherStationService.toggleStationState(stationId);
    }


}
