# 🛒 Mini Store — Online Shopping Web Application

Mini Store is a web-based e-commerce application built using **Java, Spring Boot, Thymeleaf, and Hibernate**. It allows customers to register, browse products, manage their shopping cart, place orders, and view their order history. It also provides an admin interface for adding products.

🌐 **Live Demo:** [Open Mini Store](YOUR_RENDER_URL_HERE)

📦 **GitHub Repository:** [mini-store](https://github.com/shreyas-patil-31/mini-store)

## ✨ Features

### 👤 Customer Features
- **User Registration:** Create an account with name, email, password, and date of birth.
- **User Login & Logout:** Access the store through a session-based login system.
- **Browse Products:** View available products with their prices and descriptions.
- **Category Filtering:** Filter products by category.
- **Shopping Cart:** Add products to the cart and review selected items.
- **Place Orders:** Place orders for products in the cart.
- **Order History:** View previously placed orders.

### 🛡️ Admin Features
- **Admin Login:** Access admin-specific functionality.
- **Product Management:** Add new products to the store.
- **Sample Data Initialization:** Automatically initialize the admin account, product categories, and sample products when needed.

### ✅ Additional Features
- Form validation using Jakarta Bean Validation.
- Server-side rendering with Thymeleaf.
- Database operations using Spring Data JPA and Hibernate.
- HQL queries for retrieving application data.
- Responsive, simple user interface for mobile and desktop.
- Deployment using Render and source-code management using GitHub.

## 🧰 Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Programming language |
| Spring Boot | Backend application framework |
| Spring MVC | Request handling and controllers |
| Thymeleaf | Server-side HTML templates |
| Spring Data JPA | Database access |
| Hibernate | ORM and entity management |
| HQL | Object-oriented database queries |
| H2 Database | Database for the current demo |
| Jakarta Bean Validation | Input validation |
| Maven | Dependency management and build |
| Git & GitHub | Version control and source hosting |
| Render | Application deployment |

## 🏗️ Application Architecture

The application follows a layered architecture:

- **Controller Layer:** Handles HTTP requests and responses.
- **Service Layer:** Contains application logic.
- **Repository Layer:** Performs database operations.
- **Entity Layer:** Defines database entities and relationships.
- **View Layer:** Displays pages using Thymeleaf templates.

### Application Flow

`Browser → Controller → Service → Repository → Database`

The response is rendered using Thymeleaf and returned to the browser.

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
├── pom.xml
├── Dockerfile
└── README.md
```

## 🚀 Run Locally

### Prerequisites
- Java Development Kit (JDK) 17
- Maven (or use the Maven Wrapper if available)
- Git
- An IDE such as Eclipse or IntelliJ IDEA

### 1. Clone the repository

```bash
git clone https://github.com/shreyas-patil-31/mini-store.git
cd mini-store
```

### 2. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Alternatively, import the project into Eclipse as an existing Maven project and run the main Spring Boot application class.

### 3. Open the website

Visit:

```text
http://localhost:8080
```

Register a customer account to explore the shopping features.

**Demo admin credentials:**

- Email: `admin@ministore.com`
- Password: `admin123`

> The default admin credentials are intended only for this college demonstration. Do not use them in a production deployment.

## 🗄️ Database Notes

The current demo uses an **in-memory H2 database**. The application initializes the admin account and sample products when required.

- Data is temporary and may be lost when the application restarts.
- Customer registrations and order history are not guaranteed to persist.
- Persistent database storage can be added as a future enhancement.

## 🔮 Future Improvements

- Integrate a persistent database such as PostgreSQL or MySQL.
- Implement secure password hashing and stronger authentication.
- Add product editing and deletion for administrators.
- Add product images, search, and sorting.
- Improve order management and inventory tracking.
- Add automated tests and improve application security.

## 🎓 Project Information

**Project Name:** Mini Store  
**Project Type:** Web-Based E-Commerce Application  
**Framework:** Spring Boot  
**Purpose:** Academic project for learning Java web development, MVC architecture, database integration, validation, and deployment.

## 👨‍💻 Author

**Shreyas Patil**

- GitHub: [@shreyas-patil-31](https://github.com/shreyas-patil-31)

---

⭐ If you find this project useful, feel free to explore the repository and its implementation.
