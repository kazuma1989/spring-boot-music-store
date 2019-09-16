
package com.github.kazuma1989.sbms.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@SessionScope
@Component("cartSession")
public class CartSession {

    @Getter
    @Setter
    private List<CartItemVO> cartList = new ArrayList<>();
}
