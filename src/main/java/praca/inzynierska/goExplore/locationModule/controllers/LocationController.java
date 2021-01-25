package praca.inzynierska.goExplore.locationModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import praca.inzynierska.goExplore.models.DTOs.CardLocationDTO;
import praca.inzynierska.goExplore.locationModule.models.Location;
import praca.inzynierska.goExplore.locationModule.services.LocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping("/add")
    public String saveLocation(@RequestBody Location location) {
        return this.locationService.saveLocation(location);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable(value="id", required=true) String id, @RequestBody Location location){
        this.locationService.updateLocation(location, id);
        return ResponseEntity.ok("Zaktualizowano pomyślnie");
    }

    @GetMapping("/get/{id}")
    public Optional<Location> getLocation(@PathVariable(value="id", required=true) String id){
        return this.locationService.getLocation(id);
    }

    @GetMapping("/get")
    public List<Location> getAllLocation() {
        return this.locationService.getAllLocations();
    }

    @GetMapping("/get-cards")
    public List<CardLocationDTO> getCardsLocation() {
        return this.locationService.getAllCordLocations();
    }
}
