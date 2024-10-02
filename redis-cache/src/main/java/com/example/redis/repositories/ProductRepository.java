package com.example.redis.repositories;

import com.example.redis.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final RedisTemplate<String, Object> template;
    private final String HASH_KEY = "Product";

    public ProductRepository(RedisTemplate<String, Object> template) {
        this.template = template;
    }

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY).stream()
                                    .map(obj -> (Product) obj).toList();
    }

    public Product findById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String delete(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "product deleted";
    }
}
