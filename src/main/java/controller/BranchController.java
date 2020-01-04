package controller;

import model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.BranchService;

@RestController
@RequestMapping("admin/branches")
public class BranchController {

    private BranchService branchService;

    @Autowired
    private BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public String getAllBranches(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        return "admin/branches";
    }

    @PostMapping(value = "/save")
    public String save(@RequestBody Branch branch, Model model) {
        branchService.addBranch(branch);
        model.addAttribute("branch", branch);
        return "add_branch";
    }

}
