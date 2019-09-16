
package com.github.kazuma1989.sbms.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrderEntity {

    private Integer id;

    private Date createdAt;

    private BigDecimal totalPrice;

    private String cardName;

    private String cardNumber;

    private String cardExpiration;

    private List<ItemEntity> itemList;
}
