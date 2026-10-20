
package com.ministore.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ministore.entity.AppUser;
import com.ministore.entity.Category;
import com.ministore.entity.Product;
import com.ministore.repository.AppUserRepository;
import com.ministore.repository.CategoryRepository;
import com.ministore.repository.ProductRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeData(
            AppUserRepository userRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {

        return args -> {

            // Create the default admin account
            if (!userRepository.existsByEmail("admin@ministore.com")) {
                AppUser admin = new AppUser();
                admin.setName("Store Admin");
                admin.setEmail("admin@ministore.com");
                admin.setPassword("admin123");
                admin.setDateOfBirth(LocalDate.of(1990, 1, 1));
                admin.setRole("ADMIN");

                userRepository.save(admin);
            }

            // Create categories and sample products only once
            if (categoryRepository.count() == 0) {

                Category electronics = new Category();
                electronics.setName("Electronics");
                categoryRepository.save(electronics);

                Category books = new Category();
                books.setName("Books");
                categoryRepository.save(books);

                Category stationery = new Category();
                stationery.setName("Stationery");
                categoryRepository.save(stationery);

                Product laptop = new Product();
                laptop.setName("Wireless Mouse");
                laptop.setDescription("Comfortable wireless computer mouse");
                laptop.setPrice(599.00);
                laptop.setStock(10);
                laptop.setCategory(electronics);
                productRepository.save(laptop);

                Product headphones = new Product();
                headphones.setName("Headphones");
                headphones.setDescription("Headphones for music and online classes");
                headphones.setPrice(999.00);
                headphones.setStock(8);
                headphones.setCategory(electronics);
                productRepository.save(headphones);

                Product javaBook = new Product();
                javaBook.setName("Java Programming Book");
                javaBook.setDescription("Beginner-friendly Java programming book");
                javaBook.setPrice(450.00);
                javaBook.setStock(15);
                javaBook.setCategory(books);
                productRepository.save(javaBook);

                Product notebook = new Product();
                notebook.setName("Notebook");
                notebook.setDescription("Notebook for college notes");
                notebook.setPrice(80.00);
                notebook.setStock(30);
                notebook.setCategory(stationery);
                productRepository.save(notebook);

                Product pen = new Product();
                pen.setName("Pen Set");
                pen.setDescription("Pack of blue ink pens");
                pen.setPrice(50.00);
                pen.setStock(40);
                pen.setCategory(stationery);
                productRepository.save(pen);
            }

            System.out.println("Mini Store sample data initialized.");
        };
    }
}

