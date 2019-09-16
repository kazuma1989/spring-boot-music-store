
package com.github.kazuma1989.sbms.cart;

import com.github.kazuma1989.sbms.repository.ItemEntity;
import com.github.kazuma1989.sbms.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartService {

    @Autowired
    ItemRepository repo;

    public void addTo(CartSession session, String id) {
        // TODO impl
    }
}
