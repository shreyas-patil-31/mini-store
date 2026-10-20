
package com.ministore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ministore.entity.AppUser;
import com.ministore.entity.OrderItem;
import com.ministore.entity.Orders;
import com.ministore.entity.Product;
import com.ministore.repository.OrdersRepository;
import com.ministore.repository.ProductRepository;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;

    public OrderService(
            OrdersRepository ordersRepository,
            ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Orders placeOrder(AppUser user, List<Long> productIds) {

        if (productIds == null || productIds.isEmpty()) {
            throw new IllegalArgumentException("Your cart is empty.");
        }

        Orders order = new Orders();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());

        double totalAmount = 0;

        for (Long productId : productIds) {

            Product product = productRepository.findById(productId)
                    .orElseThrow(() ->
                            new IllegalArgumentException("Product not found."));

            if (product.getStock() <= 0) {
                throw new IllegalArgumentException(
                        product.getName() + " is out of stock.");
            }

            product.setStock(product.getStock() - 1);
            productRepository.save(product);

            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(1);
            item.setPrice(product.getPrice());

            order.addItem(item);
            totalAmount += product.getPrice();
        }

        order.setTotalAmount(totalAmount);

        return ordersRepository.save(order);
    }

    public List<Orders> getOrdersByUser(Long userId) {
        return ordersRepository.findOrdersByUser(userId);
    }
}
