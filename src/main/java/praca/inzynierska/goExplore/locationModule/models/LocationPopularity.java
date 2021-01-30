package praca.inzynierska.goExplore.locationModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationPopularity {
    private String id;
    private List<TimePopularity> popularityData;
}
