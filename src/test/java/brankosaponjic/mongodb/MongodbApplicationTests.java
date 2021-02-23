package brankosaponjic.mongodb;

import brankosaponjic.mongodb.entities.Product;
import brankosaponjic.mongodb.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("Mac Book Pro");
        product.setPrice(2000f);
        Product savedProduct = productRepository.save(product);
        Assert.notNull(savedProduct,"Mustn't be null!");

        Product product2 = new Product();
        product2.setName("Iphone 12 Pro");
        product2.setPrice(1200f);
        Product savedProduct2 = productRepository.save(product2);
        Assert.notNull(savedProduct2,"Mustn't be null!");
    }

    @Test
    void testFindAll() {
        List<Product> products = productRepository.findAll();
        assertEquals(3, products.size());
    }

    @Test
    void testDelete() {
        productRepository.deleteById("60352bb79599fb557bedd240");
        Optional<Product> product = productRepository.findById("60352bb79599fb557bedd240");
        assertEquals(Optional.empty(), product);
    }

}
