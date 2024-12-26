package am.azaryan.service.impl;

import am.azaryan.entity.Category;
import am.azaryan.entity.UserType;
import am.azaryan.repository.CategoryRepository;
import am.azaryan.exception.IdNotFoundException;
import am.azaryan.security.SpringUser;
import am.azaryan.service.CategoryService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category, SpringUser springUser) {
        if (springUser.getUser().getUserType() == UserType.ADMIN) {
            category.setUser(springUser.getUser());
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        Optional<Category> byId = categoryRepository.findById(id);
        byId.ifPresent(category -> {
            categoryRepository.deleteById(id);
        });
        byId.orElseThrow(IdNotFoundException::new);
    }
}
