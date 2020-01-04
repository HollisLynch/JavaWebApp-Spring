package dao.impl;

import dao.UserDao;
import model.User;
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
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void addUser(User user) {
        em.persist(user);
        logger.info(user + " was added to DB");
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = em
                .createQuery("from User", User.class);
        logger.info("All the users was taken from DB");
        return query.getResultList();
    }

    @Override
    public void deleteUser(User user) {
       em.remove(user);
        logger.info(user + " was deleted in DB");
    }

    @Override
    public Optional<User> getById(Long id) {
        User user = em.find(User.class, id);
        logger.info("User id = " + id + " was taken from DB");
        return Optional.of(user);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        TypedQuery<User> query = em
                .createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);
        User user = (User) query.getSingleResult();
        logger.info("User email = " + email + " was taken from DB");
        return Optional.of(user);
    }

    @Override
    public void updateUser(User user) {
        User user1 = em.merge(user);
        em.persist(user1);
        logger.info(user + " was update in DB");
    }

}
