package dao.impl;

import dao.ProductDao;
import model.Product;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

  @PersistenceContext
  private EntityManager em;

    private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);

    @Override
    public void addProduct(Product product) {
        em.persist(product);
        logger.info(product + " was added in DB");
    }

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.
                createQuery("FROM Product", Product.class);
        logger.info("All the products was taken from DB");
        return query.getResultList();
    }

    @Override
    public void deleteProduct(Product product) {
        em.remove(product);
        logger.info(product + " was deleted in DB");
    }

    @Override
    public Optional<Product> getById(Long id) {
        Product product = em.find(Product.class, id);
        logger.info("Product id = " + id + " was taken from DB");
        return Optional.of(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product product1 = em.merge(product);
        em.persist(product1);
        logger.info(product + " was update in DB");
    }

}
