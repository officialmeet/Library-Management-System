# 📚 Enterprise Library Management System

A modular, object-oriented Java application designed for library inventory control, fine tracking, and member subscription management. Built using advanced data structures ($O(1)$ HashMap lookups), date arithmetic for overdue calculations, and clean package architecture.

---

## 🚀 Key Features

* **$O(1)$ Inventory Search:** Fast catalog lookups indexed by ISBN using Java `HashMap` data structures.
* **Automated Fine Engine:** Dynamic calculation of daily overdue fines ($2.50/day) based on return dates.
* **Member Account Safeguards:** Automated checkout blocks for members with outstanding fines exceeding account thresholds.
* **Clean Package Architecture:** Modular organization following production Java standards (`com.library`).

---

## 🛠️ Project Structure

```text
LibrarySystem/
└── src/
    └── com/
        └── library/
            ├── Book.java        # Entity model for book attributes and availability state
            ├── Member.java      # Profile model tracking borrowed items and unpaid fines
            ├── Library.java     # Core engine handling checkouts, returns, and fine logic
            └── LibraryApp.java  # Main application execution driver
