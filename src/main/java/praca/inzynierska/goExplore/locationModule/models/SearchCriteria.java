package praca.inzynierska.goExplore.locationModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import praca.inzynierska.goExplore.models.enums.EActivityType;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private Integer avgCost;
    private Integer maxPeoples;
    private EActivityType activityType;
}
