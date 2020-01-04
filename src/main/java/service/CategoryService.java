package service;

import model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void addCategory(Category cat);

    List<Category> getAllCategories();

    void deleteCategory(Category cat);

    Optional<Category> getById(Long catId);

    void updateCategory(Category cat);
}
