package praca.inzynierska.goExplore.locationModule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import praca.inzynierska.goExplore.locationModule.models.LocationPopularity;
import praca.inzynierska.goExplore.locationModule.models.TimePopularity;
import praca.inzynierska.goExplore.locationModule.repositories.PopularityRepository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class PopularityService {
    @Autowired
    PopularityRepository popularityRepository;

    public void saveLocationPopularity(LocationPopularity locationPopularity){
        this.popularityRepository.save(locationPopularity);
    }

    public void updatePopularity(LocationPopularity locationPopularity){
        AtomicBoolean finded = new AtomicBoolean(false);
        Optional<LocationPopularity> actualLocationPopularity = this.popularityRepository.findById(locationPopularity.getId());

        TimePopularity receivePopularity = locationPopularity.getPopularityData().stream().findFirst().get();

        if(actualLocationPopularity.isEmpty()){
            this.saveLocationPopularity(locationPopularity);
        }else{
         actualLocationPopularity.ifPresent(alp -> {
            alp.getPopularityData().forEach(timePopularity -> {
                if(timePopularity.getTime().equals(receivePopularity.getTime())){
                    timePopularity.setAmount(timePopularity.getAmount()+receivePopularity.getAmount());
                    finded.set(true);
                }
            });
         });
        }
        if(finded.get()){
            actualLocationPopularity.ifPresent(alp ->{
                this.popularityRepository.save(alp);
            });
        }else{
            actualLocationPopularity.ifPresent(alp ->{
                alp.getPopularityData().add(receivePopularity);
                this.popularityRepository.save(alp);
                    });

        }
    }
}
