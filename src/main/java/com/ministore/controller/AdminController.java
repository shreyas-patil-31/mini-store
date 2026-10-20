
package com.ministore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ministore.entity.AppUser;
import com.ministore.entity.Category;
import com.ministore.entity.Product;
import com.ministore.service.CategoryService;
import com.ministore.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

    private final ProductService productService;
    private final CategoryService categoryService;

    public AdminController(
            ProductService productService,
            CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    private boolean isAdmin(HttpSession session) {
        AppUser user =
                (AppUser) session.getAttribute("loggedInUser");

        return user != null && "ADMIN".equals(user.getRole());
    }

    @GetMapping("/admin/products/add")
    public String showAddProductForm(
            HttpSession session,
            Model model) {

        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        model.addAttribute("categories",
                categoryService.getAllCategories());

        return "admin-product";
    }

    @PostMapping("/admin/products/add")
    public String addProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam int stock,
            @RequestParam Long categoryId,
            HttpSession session,
            Model model) {

        if (!isAdmin(session)) {
            return "redirect:/login";
        }

        if (name.isBlank() || description.isBlank()
                || price <= 0 || stock < 0) {

            model.addAttribute("error",
                    "Enter valid product details.");
            model.addAttribute("categories",
                    categoryService.getAllCategories());

            return "admin-product";
        }

        Category category = categoryService
                .findByName(
                        categoryService.getAllCategories()
                                .stream()
                                .filter(c -> c.getId().equals(categoryId))
                                .map(Category::getName)
                                .findFirst()
                                .orElse(""));

        if (category == null) {
            model.addAttribute("error", "Please select a valid category.");
            model.addAttribute("categories",
                    categoryService.getAllCategories());

            return "admin-product";
        }

        Product product = new Product();
        product.setName(name.trim());
        product.setDescription(description.trim());
        product.setPrice(price);
        product.setStock(stock);
        product.setCategory(category);

        productService.saveProduct(product);

        return "redirect:/products";
    }
}

