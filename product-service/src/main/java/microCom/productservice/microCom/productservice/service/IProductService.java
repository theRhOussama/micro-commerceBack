package microCom.productservice.microCom.productservice.service;

import microCom.productservice.microCom.productservice.dto.ProductRequest;
import microCom.productservice.microCom.productservice.dto.ProductResponse;

import java.util.List;

public interface IProductService {
     void createProduct(ProductRequest productRequest);
      List<ProductResponse> getAllProducts();
}
