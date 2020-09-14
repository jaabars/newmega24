package kg.megacom.mega24.models.dto;

import lombok.Data;

@Data
public class OrderAppDto {

    private int schoolNum;
    private String phoneNumber;
    private Long regionId;
    private Long districtId;
}
