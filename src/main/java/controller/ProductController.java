package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product,
                             Model model) {
        try {
            productService.addProduct(product);
            return "redirect:/admin/products";
        } catch (NumberFormatException ex) {
            model.addAttribute("validFields", "It isn't rightly. Enter the correct values.");
            return "add_product";
        }
    }

    @GetMapping("/add")
    @ModelAttribute("product")
    public ModelAndView viewAddProductPage() {
        return new ModelAndView("add_product", "product", new Product());
    }

//    @PostMapping("/update")
//    public String updateProduct(@ModelAttribute("product") Product product,
//                                @RequestParam("id") Long id,
//                                Model model) {
//        try {
//            Product productForUpdate = new Product(id, product.getTitle(),
//                    product.getDescription(), product.getPrice());
//            productService.updateProduct(productForUpdate);
//            return "redirect:/admin/products";
//        } catch (NumberFormatException ex) {
//            model.addAttribute("validValues", "Something is wrong. Try again. ");
//            return "edit_product";
//        }
//    }

    @GetMapping("/update")
    public ModelAndView updateProduct(@RequestParam("id") Long id,
                                      Model model) {
        if (nonNull(id)) {
            Optional<Product> optProduct = productService.getById(id);
            if (optProduct.isPresent()) {
                Product product = optProduct.get();
                model.addAttribute("product", product);
                return new ModelAndView("edit_product", "product", product);
            }
        }
        return new ModelAndView("edit_product");
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        if (nonNull(id)) {
            Optional<Product> optUser = productService.getById(id);
            optUser.ifPresent(productService::deleteProduct);
        }
        return "redirect:/admin/products";
    }

}
