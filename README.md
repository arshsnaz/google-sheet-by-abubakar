# 📛 Google Sheets Clone by Abubakar Chanda

## 📊 Project Description
The **Google Sheets Clone** is a web-based spreadsheet application that closely mimics Google Sheets, featuring cell operations, mathematical functions, data validation, and formatting tools. It is built using a **Java Full Stack** approach and supports CRUD operations on spreadsheet data.

This project was developed as part of an assignment for **Zeotap's Software Engineer Intern** position.

---

## 🛠 Tech Stack Used
| Component  | Technology  |
|------------|-------------|
| Frontend | React.js, CSS (Tailwind) |
| Backend  | Spring Boot, Java  |
| Database  | MySQL  |
| API Communication | RESTful APIs (Axios) |
| Security | CORS Policy (Spring Security) |
| Build Tools | Maven, npm |

---

## 📛 How to Run the Project (Step-by-Step Guide)

### 🔹 1. Clone the Repository
```sh
git clone <https://github.com/arshsnaz/google-sheet-by-abubakar>
```

### 🔹 2. Setup the Backend (Spring Boot)

💪 **Step 1: Configure MySQL Database**
1. Open MySQL Workbench and create a new database:
```sql
CREATE DATABASE googlesheetsdb;
```
2. Update database credentials in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/googlesheetsdb
spring.datasource.username=root
spring.datasource.password=your_password
```

💪 **Step 2: Run the Spring Boot Backend**
```sh
cd google-sheets-backend
mvn clean install
mvn spring-boot:run
```
The backend should now be running at: `http://localhost:9090/`

---

### 🔹 3. Setup the Frontend (React.js)
```sh
cd google-sheets-frontend
npm install
npm start
```
The frontend should now be running at: `http://localhost:3000/`

---

## ✅ Features Implemented
### 📌 Core Functionalities
✔️ Spreadsheet interface resembling **Google Sheets**
✔️ **Cell operations**: Edit, save, and delete cell content
✔️ **Drag & Drop functionality** for formulas and data
✔️ **Mathematical functions**: SUM, AVERAGE, MIN, MAX, COUNT
✔️ **Data quality functions**: TRIM, UPPER, LOWER, FIND & REPLACE
✔️ **Row & column operations**: Add, delete, and resize
✔️ **Basic formatting**: Bold, italics, font size, and color
✔️ **Data validation**: Ensures proper data entry

### 📌 Bonus Features
✔️ **Dark Mode Toggle** for improved UI experience
✔️ **Optimized search and function execution**
✔️ **UI animations & responsiveness**

---

## 🛡 Security & Performance Enhancements

### 🔒 Security
✅ **CORS Policy** – Secure API access from React frontend
✅ **Input Validation** – Prevents invalid queries
✅ **Sanitized API Requests** – Protection against SQL Injection

### ⚡ Performance
✅ **Optimized Database Queries** – Ensures fast retrieval of spreadsheet data
✅ **Lazy Loading Components** – Improves UI performance

---


## 💎 GitHub Repositories
👉 **Repository:** [Google Sheets Clone](https://github.com/arshsnaz/google-sheet-by-abubakar)
👉 **arshsnaz:** [Abubakar's Profile](https://github.com/arshsnaz)

---

## 📝 Author
👨‍💻 Developed By: **Abubakar Chanda**  
📧 Email: abubakarchanda3@gmail.com  

---

## 🚀 How to Contribute
If you'd like to contribute:
```sh
git clone https://github.com/arshsnaz/google-sheet-by-abubakar
git checkout -b feature-branch
git commit -m "Added new feature"
git push origin feature-branch
```

---

## 🎯 Final Notes
This project was created as a **Zeotap Software Engineer Intern Assignment**. It provides a fully functional spreadsheet experience using **Java Full Stack (Spring Boot, React, MySQL)**.

Thank you for checking out the project! 🙌

