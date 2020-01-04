package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.CategoryService;

@RestController
@RequestMapping("admin/categories")
public class CategoryController {

    private CategoryService catService;

    @Autowired
    private CategoryController(CategoryService catService) {
        this.catService = catService;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        model.addAttribute("categories", catService.getAllCategories());
        return "admin/categories";
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody Category category, Model model) {
        catService.addCategory(category);
        model.addAttribute("category", category);
        return "add_category";
    }
}
