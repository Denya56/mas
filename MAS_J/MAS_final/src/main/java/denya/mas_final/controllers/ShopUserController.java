package denya.mas_final.controllers;

import denya.mas_final.repository.ShopUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopUserController {

    private final ShopUserRepository shopUserRepository;

    @Autowired
    public ShopUserController(ShopUserRepository shopUserRepository) {
        this.shopUserRepository = shopUserRepository;
    }

    @GetMapping("/index")
    public String showShopUserList(Model model) {
        model.addAttribute("shopSellers", shopUserRepository.findSellers());
        return "index";
    }
}
