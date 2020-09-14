package kg.megacom.mega24.models.dto;

import kg.megacom.mega24.models.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class OrderHistoryDto {

    private Long id;

    private Date startDate;
    private Date endDate;

    private Status status;


    private OrderDto order;
}
