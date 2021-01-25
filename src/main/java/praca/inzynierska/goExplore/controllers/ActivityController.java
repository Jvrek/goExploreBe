package praca.inzynierska.goExplore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import praca.inzynierska.goExplore.models.enums.EActivityType;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ActivityController {

    @GetMapping("/activity-types")
    public List<EActivityType> getActivityTypes() {
        return Arrays.asList(EActivityType.values());
    }
}
