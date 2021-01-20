package praca.inzynierska.goExplore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praca.inzynierska.goExplore.models.Location;
import praca.inzynierska.goExplore.repositories.LocationRepository;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;


    public void saveLocation(Location location){
        this.locationRepository.save(location);
    }

    public List<Location> getAllLocations(){
        return this.locationRepository.findAll();
    }
}
