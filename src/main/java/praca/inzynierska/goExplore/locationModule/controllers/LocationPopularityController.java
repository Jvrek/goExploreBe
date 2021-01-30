package praca.inzynierska.goExplore.locationModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import praca.inzynierska.goExplore.locationModule.models.LocationPopularity;
import praca.inzynierska.goExplore.locationModule.repositories.PopularityRepository;
import praca.inzynierska.goExplore.locationModule.services.PopularityService;

import java.util.Optional;

@RestController
@RequestMapping("/api/location-popularity")
public class LocationPopularityController {
    @Autowired
    PopularityService popularityService;

    @Autowired
    PopularityRepository popularityRepository;

    @PatchMapping("/update")
    public void updateLocation(@RequestBody LocationPopularity locationPopularity){
        this.popularityService.updatePopularity(locationPopularity);
    }

    @GetMapping("/get/{id}")
    public Optional<LocationPopularity> getLocationPopularity(@PathVariable(value="id", required=true) String id){
        return this.popularityRepository.findById(id);
    }
}
