
package com.github.kazuma1989.sbms.cart;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component("cartSession")
public class CartSession {

    public int cartCount = 0;
}
