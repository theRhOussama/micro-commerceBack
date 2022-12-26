package microCom.productservice.microCom.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import microCom.productservice.microCom.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

}
