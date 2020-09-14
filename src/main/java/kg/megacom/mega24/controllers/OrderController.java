package kg.megacom.mega24.controllers;

import kg.megacom.mega24.models.Response;
import kg.megacom.mega24.models.dto.OrderAppDto;
import kg.megacom.mega24.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public Response createOrder(@RequestBody OrderAppDto orderAppDto){

        return orderService.appendOrder(orderAppDto);
    }
}
