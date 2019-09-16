
package com.github.kazuma1989.sbms.cart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component("cartSession")
public class CartSession {

    /**
     * Use cartList.size()
     */
    @Deprecated(forRemoval = true)
    public int cartCount = 0;

    public List<CartItemVO> cartList = new ArrayList<>();
}
