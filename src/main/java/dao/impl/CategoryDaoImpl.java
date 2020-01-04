package dao.impl;

import dao.CategoryDao;
import model.Category;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void addCategory(Category cat) {
        em.persist(cat);
        logger.info(cat + " was added to DB");
    }
    @Override
    public List<Category> getAllCategories() {
        TypedQuery<Category> query = em
                .createQuery("from Category", Category.class);
        logger.info("All branches were taken from DB");
        return query.getResultList();
    }

    @Override
    public void deleteCategory(Category cat) {
        em.remove(cat);
        logger.info(cat + " was deleted from DB");
    }

    @Override
    public Optional<Category> getById(Long id) {
        Category cat = em.find(Category.class, id);
        logger.info("Branch id = " + id + " was taken from DB");
        return Optional.of(cat);
    }

    @Override
    public void updateCategory(Category cat) {
        Category cat1 = em.merge(cat);
        em.persist(cat1);
        logger.info(cat + " was update in DB");
    }
}
