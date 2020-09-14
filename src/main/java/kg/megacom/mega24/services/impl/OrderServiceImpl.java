package kg.megacom.mega24.services.impl;

import kg.megacom.mega24.dao.OrderRep;
import kg.megacom.mega24.mappers.OrderHistoryMapper;
import kg.megacom.mega24.mappers.OrderMapper;
import kg.megacom.mega24.mappers.SubscriberMapper;
import kg.megacom.mega24.models.Response;
import kg.megacom.mega24.models.dto.OrderAppDto;
import kg.megacom.mega24.models.dto.OrderDto;
import kg.megacom.mega24.models.dto.OrderHistoryDto;
import kg.megacom.mega24.models.dto.SubscriberDto;
import kg.megacom.mega24.models.entity.Order;
import kg.megacom.mega24.models.entity.OrderHistory;
import kg.megacom.mega24.models.enums.Status;
import kg.megacom.mega24.services.OrderHistoryService;
import kg.megacom.mega24.services.OrderService;
import kg.megacom.mega24.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRep orderRep;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private OrderHistoryService orderHistoryService;

    @Override
    public Response appendOrder(OrderAppDto orderAppDto) {

        SubscriberDto subscriberDto = subscriberService.findSubsByPhone(orderAppDto.getPhoneNumber());

        if (subscriberDto != null){
            Order lastOrder = orderRep.findTopBySubscriberOrderByIdDesc(SubscriberMapper.INSTANCE.toSubscriber(subscriberDto));
            OrderDto orderDto = OrderMapper.INSTANCE.toOrderDto(lastOrder);
            OrderHistoryDto actualOrderHistoryDto = orderHistoryService.findHistoryByOrderDto(orderDto);
            switch (actualOrderHistoryDto.getStatus()){
                case NEW:
                    actualOrderHistoryDto.setStatus(Status.CANCELED);
                    actualOrderHistoryDto.setEndDate(new Date());
                    orderHistoryService.saveOrderHistory(actualOrderHistoryDto);
                    saveOrder(orderAppDto,Status.NEW,subscriberDto.getId());
                     return Response.builder().status(1).message("Ваш запрос принят").build();

                case IN_PROCESS:
                    return Response.builder().status(2).message("Ваш запрос рассматривается").build();

                case DENIED:
                    saveOrder(orderAppDto,Status.NEW,subscriberDto.getId());
                    return Response.builder().status(1).message("Ваш запрос принят").build();
                case APPROVED:
                    return Response.builder().status(3).message("Ваш запрос ранее был подтвержден, на данный момент у вас услуга активна").build();
            }
        }else {
            saveNewOrder(orderAppDto,Status.NEW);
            return Response.builder().status(1).message("Ваш запрос принят").build();
        }

        return Response.builder().status(4).message("Пожайлуста отправьте еще раз").build();
    }

    private void saveNewOrder(OrderAppDto orderAppDto, Status status) {
        Order order = new Order();
        order = OrderMapper.INSTANCE.orderAppDtoToOrder(orderAppDto);
        order.setAddDate(new Date());
        SubscriberDto subscriberDto = subscriberService.saveSubscriber(orderAppDto.getPhoneNumber());
        order.setSubscriber(SubscriberMapper.INSTANCE.toSubscriber(subscriberDto));
        order = orderRep.save(order);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setStartDate(new Date());
        orderHistory.setStatus(status);
        orderHistory.setOrder(order);
        orderHistoryService.saveOrderHistory(OrderHistoryMapper.INSTANCE.toOrderHistoryDto(orderHistory));
    }

    private void saveOrder(OrderAppDto orderAppDto, Status status, Long  subscriberId) {
        Order order = new Order();
        order = OrderMapper.INSTANCE.orderAppDtoToOrder(orderAppDto,subscriberId);
        order.setAddDate(new Date());
        order = orderRep.save(order);
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setStartDate(new Date());
        orderHistory.setStatus(status);
        orderHistory.setOrder(order);
        orderHistoryService.saveOrderHistory(OrderHistoryMapper.INSTANCE.toOrderHistoryDto(orderHistory));
    }
}
