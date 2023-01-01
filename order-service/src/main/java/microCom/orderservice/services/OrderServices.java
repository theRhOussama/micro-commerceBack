package microCom.orderservice.services;

import microCom.orderservice.dto.OrderLineItemsDto;
import microCom.orderservice.dto.OrderRequest;
import microCom.orderservice.entities.Order;
import microCom.orderservice.entities.OrderLineItems;
import microCom.orderservice.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServices  implements  IOrderService{

        @Autowired
     OrderRepository orderRepository;
    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems=
          orderRequest.getOrderLineItemsDto()
                .stream().map(this::mapToDto).collect(Collectors.toList());

        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return  orderLineItems;

    }
}
