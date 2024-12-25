package am.azaryan.controller;

import am.azaryan.entity.Product;
import am.azaryan.service.CategoryService;
import am.azaryan.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products/{id}")
    public String productPage(@PathVariable("id") int id, ModelMap modelMap){
        Product byId = productService.findById(id);
        if(byId == null){
            return "redirect:/";
        }
        modelMap.addAttribute("product", byId);
        modelMap.addAttribute("categories", categoryService.findAll());
        return "user/productPage";
    }
}
