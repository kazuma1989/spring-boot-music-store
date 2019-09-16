
package com.github.kazuma1989.sbms.cart;

import com.github.kazuma1989.sbms.repository.ItemEntity;

import lombok.Data;

@Data
public class CartItemVO {

    private ItemEntity item;

    private int amount;
}
