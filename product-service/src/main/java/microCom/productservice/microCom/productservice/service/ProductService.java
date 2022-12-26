package microCom.productservice.microCom.productservice.service;

import microCom.productservice.microCom.productservice.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microCom.productservice.microCom.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import microCom.productservice.microCom.productservice.dto.ProductRequest;
import microCom.productservice.microCom.productservice.model.Product;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements  IProductService {
	 private  final ProductRepository productRepository;
	public void createProduct(ProductRequest productRequest) {
		  Product product = Product.builder()
				  .name(productRequest.getName()).
				  description(productRequest.getDescription()).price(productRequest.getPrice()).build();
		log.info("service class , adding product"+product.toString());
	    productRepository.save(product);
		log.info("product {} saved in database",product.getId());
	 }
	public List<ProductResponse> getAllProducts() {
		 log.info("inside getAllProducts Service Layer");
	  List<Product> products=	productRepository.findAll();
return 	products.stream().map(this::mapToProductsResponse).collect(Collectors.toList());
	}
	private ProductResponse mapToProductsResponse(Product product) {
		return  ProductResponse.builder().id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice()).build();
	}
}
