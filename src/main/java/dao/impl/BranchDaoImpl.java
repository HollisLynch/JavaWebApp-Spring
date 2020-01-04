package dao.impl;

import dao.BranchDao;
import model.Branch;
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
public class BranchDaoImpl implements BranchDao {

    @PersistenceContext
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public void addBranch(Branch branch) {
        em.persist(branch);
        logger.info(branch + " was added to DB");
    }
    @Override
    public List<Branch> getAllBranches() {
        TypedQuery<Branch> query = em
                .createQuery("from Branch", Branch.class);
        logger.info("All branches were taken from DB");
        return query.getResultList();
    }

    @Override
    public void deleteBranch(Branch branch) {
        em.remove(branch);
        logger.info(branch + " was deleted from DB");
    }

    @Override
    public Optional<Branch> getById(Long id) {
        Branch branch = em.find(Branch.class, id);
        logger.info("Branch id = " + id + " was taken from DB");
        return Optional.of(branch);
    }

    @Override
    public void updateBranch(Branch branch) {
        Branch branch1 = em.merge(branch);
        em.persist(branch1);
        logger.info(branch + " was update in DB");
    }
}
