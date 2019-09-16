
package com.github.kazuma1989.sbms.cart;

import java.util.Optional;

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

    public Optional<CartItemVO> addTo(CartSession session, String id) {
        Optional<ItemEntity> item = repo.findById(id);
        if (item.isEmpty()) {
            return Optional.empty();
        }

        Optional<CartItemVO> cartItem = session
            .getCartList()
            .stream()
            .filter(c -> c.getItem().getId().toString().equals(id))
            .findFirst();
        if (cartItem.isPresent()) {
            CartItemVO v = cartItem.get();
            v.setAmount(v.getAmount() + 1);

            return Optional.of(v);
        }
        else {
            CartItemVO v = new CartItemVO();
            v.setItem(item.get());
            v.setAmount(1);

            session.getCartList().add(v);
            return Optional.of(v);
        }
    }
}
