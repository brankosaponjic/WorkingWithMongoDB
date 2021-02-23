package brankosaponjic.mongodb;

import brankosaponjic.mongodb.entities.Product;
import brankosaponjic.mongodb.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MongodbApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void testSave() {
        Product product = new Product();
        product.setName("iPad Pro");
        product.setPrice(799f);
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct,"Mustn't be null!");

        Product product2 = new Product();
        product2.setName("iPad mini");
        product2.setPrice(399f);
        Product savedProduct2 = productRepository.save(product2);
        assertNotNull(savedProduct2,"Mustn't be null!");
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

    @Test
    void testUpdate() {
        Optional<Product> product = productRepository.findById("603533060c953039c5995844");
        if (product.isPresent()){
            product.get().setPrice(899f);
            productRepository.save(product.get());
        }
    }



}
