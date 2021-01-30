package praca.inzynierska.goExplore.locationModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimePopularity {
    private String time;
    private int amount;
}
