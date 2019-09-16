
package com.github.kazuma1989.sbms.order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.github.kazuma1989.sbms.cart.CartSession;
import com.github.kazuma1989.sbms.repository.ItemEntity;
import com.github.kazuma1989.sbms.repository.OrderEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CartSession session;

    @Autowired
    OrderService service;

    @GetMapping("/input")
    public String input(Model model) {
        model.addAttribute("totalPrice", 1000);
        return "order-input";
    }

    @PostMapping("/input")
    public String confirm(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("totalPrice", 1000);
        model.addAttribute("cardName", params.get("cardName"));
        model.addAttribute("cardNumber", params.get("cardNumber"));
        model.addAttribute("expiringMonth", params.get("expiringMonth"));
        model.addAttribute("expiringYear", params.get("expiringYear"));
        model.addAttribute("itemList", List.of(supply(() -> {
            ItemEntity i = new ItemEntity();
            i.setId(1);
            return i;
        }), supply(() -> {
            ItemEntity i = new ItemEntity();
            i.setId(2);
            return i;
        })));

        return "order-confirm";
    }

    @PostMapping("/complete")
    public String complete(@RequestParam Map<String, String> params, Model model) {
        OrderEntity order = new OrderEntity();
        order.setTotalPrice(BigDecimal.valueOf(1000));
        order.setCardName(params.get("cardName"));
        order.setCardNumber(params.get("cardNumber"));
        order.setCardExpiration(params.get("expiringMonth") + params.get("expiringYear"));
        order.setItemList(List.of(supply(() -> {
            ItemEntity i = new ItemEntity();
            i.setId(1);
            return i;
        }), supply(() -> {
            ItemEntity i = new ItemEntity();
            i.setId(2);
            return i;
        })));

        service.order(order);

        model.addAttribute("orderId", order.getId());
        model.addAttribute("createdAt", order.getCreatedAt());
        return "order-complete";
    }

    static <T> T supply(Supplier<T> supplier) {
        return supplier.get();
    }
}
