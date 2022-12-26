package microCom.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import microCom.productservice.microCom.productservice.ProductServiceApplication;
import microCom.productservice.microCom.productservice.controller.ProductController;
import microCom.productservice.microCom.productservice.dto.ProductRequest;
import microCom.productservice.microCom.productservice.repository.ProductRepository;
import microCom.productservice.microCom.productservice.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@ContextConfiguration(classes = {
		ProductService.class,
		MongoDBContainer.class,
		ProductRepository.class,
		ProductServiceApplication.class
})
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	ProductRepository productRepository;
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest requestDTO = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(requestDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/serviceController/createProduct")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepository.findAll().size());//excpected 1 repository

	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("productTest")
				.description("descTest")
				.price(BigDecimal.valueOf(23413))
				.build();
	}
}
