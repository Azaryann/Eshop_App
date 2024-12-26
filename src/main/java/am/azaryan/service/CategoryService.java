package am.azaryan.service;

import am.azaryan.entity.Category;
import am.azaryan.security.SpringUser;

import java.util.List;

public interface CategoryService {

    Category save(Category category, SpringUser springUser);

    List<Category> findAll();

    void deleteById(int id);

}
