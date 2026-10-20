
package com.ministore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ministore.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
