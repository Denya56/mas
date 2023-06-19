package denya.mas_final.controllers;

import denya.mas_final.repository.ProductCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductCopyController {

    private final ProductCopyRepository productCopyRepository;

    @Autowired
    public ProductCopyController(ProductCopyRepository productCopyRepository) {
        this.productCopyRepository = productCopyRepository;
    }

    @GetMapping("/products/user/{id}")
    public String showUserProducts(@PathVariable("id") Long id, Model model) {
        System.out.println("Seller: " + id);
        var pr = productCopyRepository.findBySeller(id);
        model.addAttribute("userProducts", pr);
        model.addAttribute("userId", id);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String showProductDetails(@RequestParam("userId") Long userId, @PathVariable("id") long id, Model model) {
        var pd = productCopyRepository.getDetailsById(id);
        model.addAttribute("productDetails", pd);
        System.out.println(pd.getProductPlatform());
        model.addAttribute("userId", userId);
        return "productDetails";
    }


}
