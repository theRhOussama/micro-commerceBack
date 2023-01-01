package ma.microservices.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import ma.microservices.inventoryservice.errors.InventoryExceptionHandler;
import ma.microservices.inventoryservice.services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventoryService")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode)  {
        return  inventoryService.isInStock(skuCode);
    }
}
