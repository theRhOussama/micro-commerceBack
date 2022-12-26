package microCom.orderservice.services;

import microCom.orderservice.dto.OrderRequest;

public interface IOrderService {
    void placeOrder(OrderRequest orderRequest);
}
