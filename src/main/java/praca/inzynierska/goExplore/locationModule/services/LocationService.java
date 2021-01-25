package praca.inzynierska.goExplore.locationModule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praca.inzynierska.goExplore.models.DTOs.CardLocationDTO;
import praca.inzynierska.goExplore.locationModule.models.Location;
import praca.inzynierska.goExplore.locationModule.repositories.LocationRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;


    public String saveLocation(Location location){
       return this.locationRepository.save(location).getId();
    }

    public void updateLocation(Location newLocation, String id){
        Optional<Location> location = this.locationRepository.findById(id);
        location.ifPresent(loc -> {
            if(newLocation.getName() != null){
                loc.setName(newLocation.getName());
            }
            if(newLocation.getDescription() != null){
                loc.setDescription(newLocation.getDescription());
            }
            if(newLocation.getImages() != null){
                loc.setImages(newLocation.getImages());
            }
            if(newLocation.getLatLng() != null){
                loc.setLatLng(newLocation.getLatLng());
            }
            this.locationRepository.save(loc);
        });
    }

    public List<Location> getAllLocations(){
        return this.locationRepository.findAll();
    }

    public Optional<Location> getLocation(String id){
        return this.locationRepository.findById(id);
    }

    public List<CardLocationDTO> getAllCordLocations(){
        List<CardLocationDTO> cardLocationDTOS = new LinkedList<>();

      return  this.locationRepository.findAll()
              .stream()
              .map(CardLocationDTO::toCardLocationDTO)
              .collect(Collectors.toList());
//        this.locationRepository.findAll().forEach(loc->{
//            cardLocationDTOS.add(CardLocationDTO.toCardLocationDTO(loc));
//        });

//        return cardLocationDTOS;
    }

}
