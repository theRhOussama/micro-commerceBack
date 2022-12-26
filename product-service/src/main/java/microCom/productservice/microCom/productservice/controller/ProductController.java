package microCom.productservice.microCom.productservice.controller;

import microCom.productservice.microCom.productservice.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microCom.productservice.microCom.productservice.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import microCom.productservice.microCom.productservice.dto.ProductRequest;
import microCom.productservice.microCom.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/serviceController")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
	private  final  ProductService productService;


	@PostMapping(value = "/createProduct")
	@ResponseStatus(HttpStatus.CREATED)
	 public void createProduct(@RequestBody ProductRequest productRequest) {
		log.info("Creating a product inside Controller Layer");
		productService.createProduct(productRequest);
		log.info("Controller createProduct ...service Finished");
	 }
	 @GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts()
	 {
		return productService.getAllProducts();
	 }

}
