package am.azaryan.service;

import am.azaryan.entity.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

}
