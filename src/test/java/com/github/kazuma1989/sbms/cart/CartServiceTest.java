
package com.github.kazuma1989.sbms.cart;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

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

        assertThat(cartSession.cartList, hasSize(1));
    }
}
