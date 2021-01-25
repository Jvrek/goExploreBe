package praca.inzynierska.goExplore.userModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import praca.inzynierska.goExplore.models.enums.EActivityType;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPreferences {
    private int budget;
    private EActivityType activityType;
    @Size(max = 5, min = 1)
    private int peopleAmount;
}
