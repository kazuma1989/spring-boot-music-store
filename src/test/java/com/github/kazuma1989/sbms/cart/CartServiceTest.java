
package com.github.kazuma1989.sbms.cart;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Optional;
import java.util.function.Supplier;

import com.github.kazuma1989.sbms.repository.ItemEntity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Sql({
    "/init_test_data.sql",
})
public class CartServiceTest {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    @Autowired
    CartService service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addTo_カートに追加できる() throws Exception {
        CartSession cartSession = new CartSession();
        String itemId = "1";

        service.addTo(cartSession, itemId);

        assertThat(cartSession.getCartList(), hasSize(1));
        assertThat(cartSession.getCartList().get(0).getAmount(), is(1));
    }

    @Test
    public void addTo_カートに追加できる_すでにある物を増やす() throws Exception {
        CartSession cartSession = new CartSession();
        cartSession.getCartList().add(supply(() -> {
            CartItemVO v = new CartItemVO();
            v.setAmount(2);
            v.setItem(supply(() -> {
                ItemEntity item = new ItemEntity();
                item.setId(1);
                return item;
            }));
            return v;
        }));
        String itemId = "1";

        service.addTo(cartSession, itemId);

        assertThat(cartSession.getCartList(), hasSize(1));
        assertThat(cartSession.getCartList().get(0).getAmount(), is(3));
    }

    @Test
    public void addTo_存在しない商品のときはEmptyを返す() throws Exception {
        CartSession cartSession = new CartSession();
        String itemId = "not exist";

        assertThat(service.addTo(cartSession, itemId), is(Optional.empty()));
        assertThat(cartSession.getCartList(), hasSize(0));
    }

    static <T> T supply(Supplier<T> supplier) {
        return supplier.get();
    }
}
