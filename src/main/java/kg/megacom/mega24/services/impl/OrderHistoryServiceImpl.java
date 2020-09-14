package kg.megacom.mega24.services.impl;

import kg.megacom.mega24.dao.OrderHistoryRep;
import kg.megacom.mega24.mappers.OrderHistoryMapper;
import kg.megacom.mega24.mappers.OrderMapper;
import kg.megacom.mega24.models.dto.OrderDto;
import kg.megacom.mega24.models.dto.OrderHistoryDto;
import kg.megacom.mega24.models.entity.OrderHistory;
import kg.megacom.mega24.services.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryRep orderHistoryRep;

    @Override
    public OrderHistoryDto findHistoryByOrderDto(OrderDto orderDto) {
        OrderHistory orderHistory = orderHistoryRep.findByOrderAndEndDateIsNull(OrderMapper.INSTANCE.toOrder(orderDto));

        return OrderHistoryMapper.INSTANCE.toOrderHistoryDto(orderHistory);
    }

    @Override
    public OrderHistoryDto saveOrderHistory(OrderHistoryDto orderHistoryDto) {
        OrderHistory orderHistory = OrderHistoryMapper.INSTANCE.toOrderHistory(orderHistoryDto);
        orderHistory = orderHistoryRep.save(orderHistory);
       return OrderHistoryMapper.INSTANCE.toOrderHistoryDto(orderHistory);

    }
}
