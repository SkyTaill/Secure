package ru.gb.ProductRep;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(float id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }


    public Product save(Product product) {
        int idImitation = this.products.size() + 1;
        product.setId(idImitation);
        products.add(product);
        return product;
    }

}