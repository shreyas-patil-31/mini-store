
package com.ministore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ministore.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT o FROM Orders o WHERE o.user.id = :userId ORDER BY o.orderDate DESC")
    List<Orders> findOrdersByUser(@Param("userId") Long userId);
}

