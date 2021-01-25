package praca.inzynierska.goExplore.locationModule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import praca.inzynierska.goExplore.models.Image;

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
}
