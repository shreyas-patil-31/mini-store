
package com.ministore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ministore.entity.AppUser;
import com.ministore.service.CategoryService;
import com.ministore.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(
            ProductService productService,
            CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String showProducts(
            @RequestParam(required = false) Long categoryId,
            HttpSession session,
            Model model) {

        AppUser user = (AppUser) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        if (categoryId != null) {
            model.addAttribute(
                    "products",
                    productService.getProductsByCategory(categoryId));
        } else {
            model.addAttribute(
                    "products",
                    productService.getAllProducts());
        }

        model.addAttribute(
                "categories",
                categoryService.getAllCategories());

        model.addAttribute("selectedCategoryId", categoryId);
        model.addAttribute("loggedInUser", user);

        return "products";
    }
}
