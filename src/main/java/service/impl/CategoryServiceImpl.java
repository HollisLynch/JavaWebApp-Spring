package service.impl;


import dao.CategoryDao;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CategoryService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao catDao;

    public CategoryServiceImpl() {
    }

    @Autowired
    public CategoryServiceImpl(CategoryDao catDao) {
        this.catDao = catDao;
    }

    public void addCategory(Category cat) {
        catDao.addCategory(cat);
    }

    public List<Category> getAllCategories() {
        return catDao.getAllCategories();
    }

    public void deleteCategory(Category cat) {
        catDao.deleteCategory(cat);
    }

    public Optional<Category> getById(Long catId) {
        return catDao.getById(catId);
    }

    public void updateCategory(Category cat) {
        catDao.updateCategory(cat);
    }
}
