package praca.inzynierska.goExplore.locationModule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praca.inzynierska.goExplore.locationModule.models.SearchCriteria;
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
    public void deleteLocation(String id){
        this.locationRepository.deleteById(id);
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
            if(newLocation.getActivityType() != null){
                loc.setActivityType(newLocation.getActivityType());
            }
            if(newLocation.getAvgCost() != null){
                loc.setAvgCost(newLocation.getAvgCost());
            }
            if(newLocation.getMaxPeoples() != null){
                loc.setMaxPeoples(newLocation.getMaxPeoples());
            }
            this.locationRepository.save(loc);
        });
    }

    public List<Location> getAllLocations(){
        return this.locationRepository.findAll();
    }

    public List<Location> getAllOwnedLocations(String id){
        return this.locationRepository.findByOwnerId(id);
    }



    public List<Location> getFilteredLocations(SearchCriteria searchCriteria){
        List<Location> locations = this.locationRepository.findAll();
        List<Location> filteredLocations;
        filteredLocations = locations.stream()
                .filter(location -> {
                    if(searchCriteria.getAvgCost() == null){
                        return true;
                    }
                    return location.getAvgCost() <= searchCriteria.getAvgCost();
                } )
                .filter(location -> {
                    if(searchCriteria.getMaxPeoples() == null){
                        return true;
                    }
                    return location.getMaxPeoples() >= searchCriteria.getMaxPeoples();
                })
                .collect(Collectors.toList());

        if(searchCriteria.getActivityType() != null){
            locations.forEach(location -> {
                if(!location.getActivityType().contains(searchCriteria.getActivityType())){
                    filteredLocations.remove(location);
                };
            });
        }

         return filteredLocations;

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
