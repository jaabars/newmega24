package kg.megacom.mega24.models.dto;

import lombok.Data;

@Data
public class DistrictDto {

    private Long id;

    private String name;
    private boolean active;


    private RegionDto region;
}
