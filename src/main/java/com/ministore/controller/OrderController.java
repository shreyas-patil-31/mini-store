
package com.ministore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ministore.entity.AppUser;
import com.ministore.entity.Orders;
import com.ministore.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/orders/place")
    public String placeOrder(HttpSession session) {

        AppUser user = (AppUser) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Map<Long, Integer> cart =
                (Map<Long, Integer>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            return "redirect:/cart";
        }

        List<Long> productIds = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                productIds.add(entry.getKey());
            }
        }

        try {
            orderService.placeOrder(user, productIds);
            cart.clear();
            return "redirect:/orders?success";
        } catch (IllegalArgumentException e) {
            session.setAttribute("orderError", e.getMessage());
            return "redirect:/cart";
        }
    }

    @GetMapping("/orders")
    public String viewOrders(HttpSession session, Model model) {

        AppUser user = (AppUser) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        List<Orders> orders = orderService.getOrdersByUser(user.getId());

        model.addAttribute("orders", orders);

        return "orders";
    }
}

