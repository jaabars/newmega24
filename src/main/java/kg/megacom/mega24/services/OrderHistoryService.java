package kg.megacom.mega24.services;

import kg.megacom.mega24.models.dto.OrderDto;
import kg.megacom.mega24.models.dto.OrderHistoryDto;

public interface OrderHistoryService {

    OrderHistoryDto findHistoryByOrderDto(OrderDto orderDto);
    OrderHistoryDto saveOrderHistory(OrderHistoryDto orderHistoryDto);
}
