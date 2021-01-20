package praca.inzynierska.goExplore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import praca.inzynierska.goExplore.models.Location;
import praca.inzynierska.goExplore.services.LocationService;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping("/add")
    public void saveCarAdvertisement(@RequestBody Location location) {
        this.locationService.saveLocation(location);
    }
}
