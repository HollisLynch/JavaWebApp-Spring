package dao;

import model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    void addCategory(Category cat);

    List<Category> getAllCategories();

    void deleteCategory(Category cat);

    Optional<Category> getById(Long id);

    void updateCategory(Category cat);
}
