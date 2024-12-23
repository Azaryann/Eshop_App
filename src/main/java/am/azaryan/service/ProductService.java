package am.azaryan.service;

import am.azaryan.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findById(int id);

}
