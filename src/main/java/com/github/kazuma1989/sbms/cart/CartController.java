
package com.github.kazuma1989.sbms.cart;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/")
    public String update(@RequestParam String action, UpdateParam param, Model model) {
        switch (action) {
            case "add": {
                service.addTo(session, param.itemId);

                return "cart-detail";
            }

            default: {
                throw new ResponseStatusException(BAD_REQUEST);
            }
        }
    }
}
