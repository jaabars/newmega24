package kg.megacom.mega24.services;

import kg.megacom.mega24.models.Response;
import kg.megacom.mega24.models.dto.OrderAppDto;

public interface OrderService {

    Response appendOrder(OrderAppDto orderAppDto);
}
