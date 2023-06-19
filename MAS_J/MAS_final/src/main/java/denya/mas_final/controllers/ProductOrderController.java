package denya.mas_final.controllers;

import denya.mas_final.model.ProductCopy;
import denya.mas_final.model.ProductOrder;
import denya.mas_final.model.ShopUser;
import denya.mas_final.repository.ProductCopyRepository;
import denya.mas_final.repository.ProductOrderRepository;
import denya.mas_final.repository.ShopUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ProductOrderController {
    private final ProductOrderRepository productOrderRepository;
    private final ProductCopyRepository productCopyRepository;
    private final ShopUserRepository shopUserRepository;

    @Autowired
    public ProductOrderController(ProductOrderRepository productOrderRepository, ProductCopyRepository productCopyRepository, ShopUserRepository shopUserRepository) {
        this.productOrderRepository = productOrderRepository;
        this.productCopyRepository = productCopyRepository;
        this.shopUserRepository = shopUserRepository;
    }

    @GetMapping("/buyProduct")
    public String showProductPurchaseForm(@RequestParam("product_id") Long productCopyId,
                                          @RequestParam("userId") Long shopUserId,
                                          Model model) {
        ProductOrder productOrder = new ProductOrder();

        ProductCopy productCopy = productCopyRepository.findById(productCopyId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        ShopUser shopUser = shopUserRepository.findById(shopUserId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        productOrder.setProductCopy(productCopy);
        productOrder.setShopUser(shopUser);
        productOrder.setPurchaseDate(LocalDate.now());

        model.addAttribute("productOrder", productOrder);
        return "buyProduct";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute("productOrder") @Valid ProductOrder productOrder,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productOrder", productOrder);
            return "buyProduct";
        }

        productOrderRepository.save(productOrder);
        return "confirmation";
    }

    @GetMapping("/confirmation")
    public String confirmation(@PathVariable("id") Long productId, Model model) {
        var productOrder = productOrderRepository.findById(productId);
        model.addAttribute("productOrder", productOrder);
        return "confirmation";
    }
}
