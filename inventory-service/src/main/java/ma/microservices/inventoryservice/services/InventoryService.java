package ma.microservices.inventoryservice.services;

import lombok.RequiredArgsConstructor;
import ma.microservices.inventoryservice.errors.InventoryExceptionHandler;
import ma.microservices.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@Transactional
public class InventoryService {
    @Autowired
    private    InventoryRepository inventoryRepository;

        @Transactional(readOnly = true)
    public boolean isInStock(String skuCode)
    {
        return  inventoryRepository.findBySkuCode(skuCode).isPresent();
    }


}
