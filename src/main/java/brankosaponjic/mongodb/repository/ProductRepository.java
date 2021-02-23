package brankosaponjic.mongodb.repository;

import brankosaponjic.mongodb.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
