package microCom.orderservice.controllers;

import lombok.RequiredArgsConstructor;
import microCom.orderservice.dto.OrderRequest;
import microCom.orderservice.services.OrderServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderServices")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServices orderServices;


    @PostMapping(value = "/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
    orderServices.placeOrder(orderRequest);
   return "order placed successfully";
    }

}
