
package com.github.kazuma1989.sbms.item;

import java.util.List;
import java.util.Optional;

import com.github.kazuma1989.sbms.repository.ItemEntity;
import com.github.kazuma1989.sbms.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository repo;

    public List<ItemEntity> findNewItems() {
        return repo.findNewItems();
    }

    public Optional<ItemEntity> findById(String id) {
        return repo.findById(id);
    }
}
