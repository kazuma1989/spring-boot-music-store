
package com.github.kazuma1989.sbms.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
    public int create(OrderEntity order) {
        // jdbc
        // .update(
        // "INSERT INTO (created_at, total_price, card_name, card_number, card_expiration)"
        // + " VALUES (CURRENT_DATE, total_price, card_name, card_number, card_expiration)",
        // new MapSqlParameterSource());
        // TODO Auto-generated method stub
        return 0;
    }

    private static OrderEntity rowMapper(ResultSet rs, int rowNum) throws SQLException {
        OrderEntity e = new OrderEntity();
        return e;
    }
}
