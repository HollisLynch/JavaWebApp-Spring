package service.impl;

import dao.BranchDao;
import model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import service.BranchService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    private BranchDao branchDao;

    public BranchServiceImpl() {
    }

    @Autowired
    public BranchServiceImpl(BranchDao branchDao) {
        this.branchDao = branchDao;
    }

    public void addBranch(Branch branch) {
        branchDao.addBranch(branch);
    }

    public List<Branch> getAllBranches() {
        return branchDao.getAllBranches();
    }

    public void deleteBranch(Branch branch) {
        branchDao.deleteBranch(branch);
    }

    public Optional<Branch> getById(Long branchId) {
        return branchDao.getById(branchId);
    }

    public void updateBranch(Branch branch) {
        branchDao.updateBranch(branch);
    }

}
