
package com.ministore.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ministore.entity.AppUser;
import com.ministore.entity.Product;
import com.ministore.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @SuppressWarnings("unchecked")
    private Map<Long, Integer> getCart(HttpSession session) {
        Map<Long, Integer> cart =
                (Map<Long, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new LinkedHashMap<>();
            session.setAttribute("cart", cart);
        }

        return cart;
    }

    @PostMapping("/cart/add")
    public String addToCart(
            @RequestParam Long productId,
            HttpSession session) {

        AppUser user = (AppUser) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Product product = productService.getProductById(productId)
                .orElse(null);

        if (product == null || product.getStock() <= 0) {
            return "redirect:/products";
        }

        Map<Long, Integer> cart = getCart(session);
        int currentQuantity = cart.getOrDefault(productId, 0);

        if (currentQuantity < product.getStock()) {
            cart.put(productId, currentQuantity + 1);
        }

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {

        AppUser user = (AppUser) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Map<Long, Integer> cart = getCart(session);
        List<Product> products = new ArrayList<>();
        double total = 0;

        for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
            Product product = productService
                    .getProductById(entry.getKey())
                    .orElse(null);

            if (product != null) {
                products.add(product);
                total += product.getPrice() * entry.getValue();
            }
        }

        model.addAttribute("products", products);
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);

        return "cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(
            @RequestParam Long productId,
            HttpSession session) {

        AppUser user = (AppUser) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Map<Long, Integer> cart = getCart(session);
        cart.remove(productId);

        return "redirect:/cart";
    }
}
