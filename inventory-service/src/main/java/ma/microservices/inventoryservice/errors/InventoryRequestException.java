package ma.microservices.inventoryservice.errors;

public class InventoryRequestException extends  RuntimeException {

    public InventoryRequestException(String message){
        super(message);
    }
    public InventoryRequestException(String message, Throwable cause){
        super(message,cause);
    }
}
