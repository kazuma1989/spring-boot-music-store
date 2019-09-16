
package com.github.kazuma1989.sbms.order;

import com.github.kazuma1989.sbms.repository.OrderEntity;
import com.github.kazuma1989.sbms.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository repo;

    public void order(OrderEntity order) {

    }
}
