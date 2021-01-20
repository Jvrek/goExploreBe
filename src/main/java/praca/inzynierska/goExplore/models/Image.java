package praca.inzynierska.goExplore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @NotBlank
    private String name;

    @NotBlank
    private String url;
}
