# 🍽️ Canteen Ordering System

An intermediate-level full stack project built using:

* Java (Swing + JDBC) for the Admin Panel
* MySQL for database
* React.js for the customer-facing frontend
* JSON-based data flow for React integration

## 🛠️ Features

### 🧑‍💻 Admin Panel (Java Desktop GUI)

* Login system (local)
* Add / Update / Delete food items
* View customer orders (from orders.json or DB)
* Export menu and orders to JSON

### 🌐 Customer Frontend (React)

* Browse and filter food menu
* Add to cart and place orders
* View order confirmation and status

## 🗃️ Technologies Used

* Java, Swing, JDBC
* MySQL
* React.js
* Gson (for JSON export)
* Node/npm (React setup)

---

## 📦 Folder Structure

```
canteen-ordering-system/
│
├── java-admin/            # Java Swing App (Admin)
│   ├── src/
│   ├── db_config.properties
│   └── ExportJSON.java
│
├── react-frontend/        # React Customer UI
│   ├── public/menu.json
│   ├── src/
│
├── sql/                   # Database Schema and Sample Data
│   └── canteen.sql
│
└── README.md
---
