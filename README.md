# 🛒 Mini Store — Full-Stack E-Commerce Web Application

A web-based e-commerce application built with **Java, Spring Boot, Thymeleaf, and Hibernate**, featuring customer authentication, product browsing, shopping cart management, order placement, order history, and admin-side product management.

🌐 **Live Demo:** [Visit Mini Store](https://mini-store-l9ph.onrender.com)  
💻 **Source Code:** [GitHub Repository](https://github.com/shreyas-patil-31/mini-store)

## 📌 Overview

Mini Store is an e-commerce web application developed to demonstrate practical Java backend development, MVC architecture, database integration, server-side rendering, form validation, and deployment.

Customers can create accounts, browse products by category, add products to a shopping cart, place orders, and view their order history. Administrators can access admin-specific functionality to add products to the store.

## ✨ Features

### Customer Features
- **User Registration:** Create an account with name, email, password, and date of birth.
- **Login & Logout:** Session-based user authentication.
- **Product Catalog:** Browse products with descriptions, prices, and available stock.
- **Category Filtering:** Filter products by category.
- **Shopping Cart:** Add products and review selected items.
- **Order Placement:** Place orders from the shopping cart.
- **Order History:** View previously placed orders.

### Admin Features
- **Admin Authentication:** Access role-specific administrative functionality.
- **Product Management:** Add new products to the catalog.
- **Initial Data Setup:** Automatically initialize the admin account and sample products when required.

### Backend & Application Features
- Spring MVC request handling and controller-based routing.
- Layered architecture using controllers, services, repositories, and entities.
- Database persistence through Spring Data JPA and Hibernate.
- HQL queries for retrieving application data.
- Server-side form validation using Jakarta Bean Validation.
- Entity relationships for products, categories, orders, and order items.
- Responsive web interface accessible from desktop and mobile devices.

## 🧰 Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Backend programming |
| Spring Boot | Application framework |
| Spring MVC | Request handling |
| Thymeleaf | Server-side HTML rendering |
| Spring Data JPA | Data access layer |
| Hibernate | Object-relational mapping |
| HQL | Database queries |
| H2 Database | Database for the current demo |
| Jakarta Bean Validation | Input validation |
| Maven | Build and dependency management |
| HTML & CSS | User interface |
| Git & GitHub | Version control |
| Docker | Containerized deployment |
| Render | Cloud hosting |

## 🏗️ Architecture

The application follows a layered architecture to separate request handling, business logic, database operations, and presentation.

```text
          User / Admin
                |
                v
        Thymeleaf Web UI
                |
                v
        Spring MVC Controllers
                |
                v
          Service Layer
                |
                v
        Spring Data JPA
                |
                v
        Hibernate / H2
```

**Main layers:**

- **Controller:** Handles HTTP requests and coordinates responses.
- **Service:** Implements application logic.
- **Repository:** Provides database access through Spring Data JPA.
- **Entity:** Represents application data and database relationships.
- **View:** Renders pages using Thymeleaf templates.

## 📂 Project Structure

```text
mini-store/
├── src/
│   └── main/
│       ├── java/com/ministore/
│       │   ├── config/
│       │   ├── controller/
│       │   ├── entity/
│       │   ├── repository/
│       │   └── service/
│       └── resources/
│           ├── templates/
│           └── application.properties
├── Dockerfile
├── pom.xml
└── README.md
```

## 🚀 Run Locally

### Prerequisites
- JDK 17
- Maven 3.9+ (or the Maven Wrapper, if included)
- Git
- Eclipse, IntelliJ IDEA, or another Java IDE

### 1. Clone the repository

```bash
git clone https://github.com/shreyas-patil-31/mini-store.git
cd mini-store
```

### 2. Start the application

```bash
mvn spring-boot:run
```

Alternatively, import the repository into Eclipse as an existing Maven project and run the main Spring Boot application class.

### 3. Open the application

Navigate to:

```text
http://localhost:8080
```

Register a customer account to explore the shopping features.

### Demo Administrator Account

If the default administrator account is initialized, the demo credentials are:

- **Email:** `admin@ministore.com`
- **Password:** `admin123`

These credentials are for demonstration purposes only. Do not use them for a production deployment.

## 🗄️ Database Notes

The current deployment uses an **in-memory H2 database**.

- Database records may be lost when the application restarts.
- Customer accounts and orders are not guaranteed to persist between restarts.
- The administrator account and sample catalog are initialized automatically when needed.

A persistent database such as PostgreSQL or MySQL would be suitable for a future production-oriented version.

## 🔐 Security Considerations

This project is an academic demonstration of web application development. The current implementation uses basic session-based authentication and does not yet provide production-grade password security.

Before handling real customer data, the application should be enhanced with password hashing, stronger authentication and authorization controls, secure session settings, and appropriate production database configuration.

## 🔮 Future Enhancements

- Integrate persistent database storage.
- Implement secure password hashing and Spring Security.
- Add product editing and deletion.
- Introduce product images, search, and sorting.
- Improve inventory management and order tracking.
- Add automated tests and centralized error handling.
- Integrate a payment gateway in a future version.

## 🎯 Learning Outcomes

This project provided practical experience with:

- Developing Java web applications using Spring Boot.
- Implementing the Model-View-Controller pattern.
- Designing entities and database relationships using JPA and Hibernate.
- Handling forms, validation, and user sessions.
- Implementing repository-based data access and HQL queries.
- Packaging and deploying an application using Docker and Render.
- Managing source code with Git and GitHub.

## 👨‍💻 Author

**Shreyas Patil**

- GitHub: [@shreyas-patil-31](https://github.com/shreyas-patil-31)
- Project Repository: [Mini Store](https://github.com/shreyas-patil-31/mini-store)
- Live Application: [Mini Store Demo](https://mini-store-l9ph.onrender.com)

---

*Built as a hands-on Java and Spring Boot project to explore end-to-end web application development and deployment.*
