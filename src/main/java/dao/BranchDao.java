package dao;

import model.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchDao {

    void addBranch(Branch branch);

    List<Branch> getAllBranches();

    void deleteBranch(Branch branch);

    Optional<Branch> getById(Long id);

    void updateBranch(Branch branch);
}
