package service;

import model.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchService {

     void addBranch(Branch branch);

     List<Branch> getAllBranches();

     void deleteBranch(Branch branch);

     Optional<Branch> getById(Long branchId);

     void updateBranch(Branch branch);
}
