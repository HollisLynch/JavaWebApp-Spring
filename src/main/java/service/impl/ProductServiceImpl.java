package service.impl;

import dao.ProductDao;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    private ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }

    public Optional<Product> getById(Long id) {
        return productDao.getById(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

}
