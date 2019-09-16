
package com.github.kazuma1989.sbms.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    @Override
    public Optional<ItemEntity> findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void create(OrderEntity order) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc
            .update(
                "INSERT INTO order_ticket (created_at, total_price, card_name, card_number, card_expiration)"
                    + " VALUES (CURRENT_DATE, :total_price, :card_name, :card_number, :card_expiration)",
                new MapSqlParameterSource()
                    .addValue("total_price", order.getTotalPrice())
                    .addValue("card_name", order.getCardName())
                    .addValue("card_number", order.getCardNumber())
                    .addValue("card_expiration", order.getCardExpiration()),
                keyHolder);

        int orderId = keyHolder.getKey().intValue();
        order.setId(orderId);
        order.getItemList().forEach(item -> {
            jdbc
                .update(
                    "INSERT INTO order_detail (order_id, item_id)"
                        + " VALUES (:order_id, :item_id)",
                    new MapSqlParameterSource().addValue("order_id", orderId).addValue("item_id", item.getId()));
        });
    }

    private static OrderEntity rowMapper(ResultSet rs, int rowNum) throws SQLException {
        // TODO impl
        OrderEntity e = new OrderEntity();
        return e;
    }
}
