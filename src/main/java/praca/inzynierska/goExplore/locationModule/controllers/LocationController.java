package praca.inzynierska.goExplore.locationModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import praca.inzynierska.goExplore.locationModule.models.SearchCriteria;
import praca.inzynierska.goExplore.loginModule.security.jwt.JwtUtils;
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

    @PostMapping("/delete")
    public ResponseEntity<?> deleteLocation(@RequestBody String id){
        this.locationService.deleteLocation(id);
        return ResponseEntity.ok("Lokacja została usunięta");
    }

    @GetMapping("/get/{id}")
    public Optional<Location> getLocation(@PathVariable(value="id", required=true) String id){
        return this.locationService.getLocation(id);
    }

    @GetMapping("/get")
    public List<Location> getAllLocations() {
        return this.locationService.getAllLocations();
    }

    @GetMapping("/get-owned/{id}")
    public List<Location> getAllOwnedLocations(@PathVariable(value="id", required=true) String id) {
        return this.locationService.getAllOwnedLocations(id);
    }

    @PostMapping("/getFiltered")
    public List<Location> getFilteredLocations(@RequestBody SearchCriteria searchCriteria) {
        return this.locationService.getFilteredLocations(searchCriteria);
    }

    @GetMapping("/get-cards")
    public List<CardLocationDTO> getCardsLocation() {
        return this.locationService.getAllCordLocations();
    }
}
