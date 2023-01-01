package ma.microservices.inventoryservice.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class InventoryExceptionHandler extends Throwable {

    @ExceptionHandler(value = {InventoryRequestException.class})
    public static ResponseEntity<Object> handleInventoryRequestException(InventoryRequestException e)
    {
        //1.Create Payload Containg exception details
      InventException i =    new InventException(
                 e.getMessage(),e,
                 HttpStatus.BAD_REQUEST,
                 ZonedDateTime.now()
         );
        // 2.Return Response Entity
        return  new ResponseEntity<>(i,HttpStatus.BAD_REQUEST);
    }

}
