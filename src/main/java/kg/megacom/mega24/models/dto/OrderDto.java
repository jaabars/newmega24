package kg.megacom.mega24.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {

    private Long id;

    //private String imagePath;

    private int schoolNum;

    private Date addDate;


    private SubscriberDto subscriber;


    private RegionDto region;


    private DistrictDto district;
}
