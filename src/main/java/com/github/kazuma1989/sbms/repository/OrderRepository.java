
package com.github.kazuma1989.sbms.repository;

import java.util.Optional;

public interface OrderRepository {

    public Optional<ItemEntity> findById(String id);

    public int create(OrderEntity order);
}
