package praca.inzynierska.goExplore.locationModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import praca.inzynierska.goExplore.models.Image;
import praca.inzynierska.goExplore.models.enums.EActivityType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 120)
    private String description;

    private List<Image> Images;

    @NotBlank
    private LatLng latLng;

    @NotBlank
    private List<EActivityType> activityType;

    @NotBlank
    private Integer avgCost;

    @NotBlank
    @Size(max = 5, min = 1)
    private Integer maxPeoples;
}
