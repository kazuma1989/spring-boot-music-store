
package com.github.kazuma1989.sbms.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartSession session;

    @Autowired
    CartService service;

    @GetMapping("/")
    public String detail(Model model) {
        return "cart-detail";
    }

    @PostMapping(path = "/", params = "action-add")
    public String add(@RequestParam String itemId, Model model) {
        service.addTo(session, itemId);

        return "cart-detail";
    }
}
