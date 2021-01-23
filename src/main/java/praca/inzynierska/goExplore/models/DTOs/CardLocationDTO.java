package praca.inzynierska.goExplore.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import praca.inzynierska.goExplore.models.LatLng;
import praca.inzynierska.goExplore.models.Location;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardLocationDTO {
    private static final int FIRST_INDEX = 0;
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private LatLng latLng;

    public static CardLocationDTO toCardLocationDTO(Location location){

        return new CardLocationDTO(
                location.getId(),
                location.getName(),
                location.getDescription(),
                location.getImages().get(FIRST_INDEX).getUrl(),
                location.getLatLng()
        );
    }
}
