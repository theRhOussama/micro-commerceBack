package ma.microservices.inventoryservice.services;

import ma.microservices.inventoryservice.errors.InventoryExceptionHandler;

public interface IEnventoryService {
    boolean isInStock(String skuCode);
}
