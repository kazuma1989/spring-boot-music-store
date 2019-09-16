
package com.github.kazuma1989.sbms.repository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    public List<ItemEntity> findNewItems();

    public Optional<ItemEntity> findById(int id);
}
