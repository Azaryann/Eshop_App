package am.azaryan.controller;

import am.azaryan.entity.Category;
import am.azaryan.security.SpringUser;
import am.azaryan.service.CategoryService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String categories(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryService.findAll());
        return  "admin/categoryList";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return "redirect:/category/list";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category, @AuthenticationPrincipal SpringUser springUser) {
        categoryService.save(category, springUser);
        return "redirect:/category/list";
    }
}
