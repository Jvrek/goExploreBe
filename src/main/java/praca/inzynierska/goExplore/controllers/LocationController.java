package praca.inzynierska.goExplore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import praca.inzynierska.goExplore.models.DTOs.CardLocationDTO;
import praca.inzynierska.goExplore.models.Location;
import praca.inzynierska.goExplore.services.LocationService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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
        return ResponseEntity.ok("resource updated");
    }

    @GetMapping("/get")
    public List<Location> getLocation() {
        return this.locationService.getAllLocations();
    }

    @GetMapping("/get-cards")
    public List<CardLocationDTO> getCardsLocation() {
        return this.locationService.getAllCordLocations();
    }
}
