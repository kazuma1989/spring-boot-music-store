
package com.github.kazuma1989.sbms.order;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

import com.github.kazuma1989.sbms.repository.ItemEntity;
import com.github.kazuma1989.sbms.repository.OrderEntity;

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
public class OrderServiceTest {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    @Autowired
    OrderService service;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void findById_IDが数字でないときはEmpty回答() throws Exception {
        service.order(supply(() -> {
            OrderEntity e = new OrderEntity();
            e.setTotalPrice(BigDecimal.valueOf(1000));
            e.setCardName("ADA LOVELACE");
            e.setCardNumber("1234123412341234");
            e.setCardExpiration("0922");
            e.setItemList(List.of(supply(() -> {
                ItemEntity i = new ItemEntity();
                i.setId(1);
                return i;
            }), supply(() -> {
                ItemEntity i = new ItemEntity();
                i.setId(2);
                return i;
            })));
            return e;
        }));

        assertThat(jdbc.query("SELECT COUNT(*) FROM order_ticket", (rs, rowNum) -> rs.getInt(1)), is(1));
        assertThat(jdbc.query("SELECT COUNT(*) FROM order_detail", (rs, rowNum) -> rs.getInt(1)), is(2));
    }

    static <T> T supply(Supplier<T> supplier) {
        return supplier.get();
    }
}
