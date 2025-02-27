📜 README.md for Web Application Mimicking Google Sheets by Abubakar Chanda

📊 Web Application Mimicking Google Sheets

## 🚀 Project Description
This project is a fully functional web-based spreadsheet application that closely mimics the Google Sheets UI & functionalities. It enables users to edit, format, and perform mathematical operations on cells. The project supports drag-and-drop features, cell dependencies, and essential spreadsheet functions like `SUM`, `AVERAGE`, `MAX`, `MIN`, and `COUNT`.  

Developed using a Java Full Stack approach, it consists of:
- Frontend: React.js
- Backend: Spring Boot (Java)
- Database: MySQL  

This project was built as part of an assignment for Zeotap's Software Engineer Intern position.


## 🛠 Tech Stack Used
| Component  | Technology  |
|------------|-------------|
| Frontend | React.js, CSS (Tailwind) |
| Backend  | Spring Boot, Java  |
| Database  | MySQL  |
| State Management | React Hooks (useState, useEffect) |
| API Communication | RESTful APIs (Axios) |
| Security | CORS Policy (Spring Security) |
| Build Tools | Maven, npm |

---

## 📜 How to Run the Project (Step-by-Step Guide)

🔹 1. Clone the Repository
git clone <GITHUB_REPOSITORY_LINK>
cd web-app-google-sheets-clone


🔹 2. Setup the Backend (Spring Boot)

✅ Step 1: Configure MySQL Database

1. Open MySQL Workbench and create a new database:
CREATE DATABASE google_sheets_clone;

2. Update database credentials in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/google_sheets_clone
spring.datasource.username=root
spring.datasource.password=your_password

✅ Step 2: Run the Spring Boot Backend
cd backend
mvn clean install
mvn spring-boot:run

The backend should now be running at: http://localhost:9090/


🔹 3. Setup the Frontend (React.js)

cd frontend/google-sheets-ui
npm install
npm start

The frontend should now be running at: http://localhost:3000/

✅ Features Implemented
📌 Spreadsheet Interface
✔️ Mimics Google Sheets UI (Toolbar, Formula Bar, Cells)
✔️ Drag-and-Drop Functionality (Move data between cells)
✔️ Cell Dependencies (Auto-update when referenced cells change)
✔️ Basic Cell Formatting (Bold, Italic, Font Size, Colors)
✔️ Add/Delete/Resize Rows & Columns

📌 Mathematical Functions
✔️ SUM(A1:A3) – Adds values in a range
✔️ AVERAGE(A1:A3) – Computes the average
✔️ MAX(A1:A3) – Finds the highest number
✔️ MIN(A1:A3) – Finds the lowest number
✔️ COUNT(A1:A3) – Counts numeric cells

📌 Data Quality Functions
✔️ TRIM(A1) – Removes spaces
✔️ UPPER(A1) – Converts text to uppercase
✔️ LOWER(A1) – Converts text to lowercase
✔️ REMOVE_DUPLICATES(A1:A5) – Deletes duplicate rows
✔️ FIND_AND_REPLACE(A1:A5, "old", "new") – Replaces text

📌 Data Entry & Validation
✔️ Accepts numbers, text, and dates
✔️ Prevents invalid numeric inputs


🛡 Security & Performance Enhancements
🔐 Security
✅ CORS Policy – Secure API access from React frontend
✅ Input Validation – Prevents invalid data submissions
✅ Sanitized API Requests – Protects against SQL Injection

⚡ Performance
✅ Optimized Database Queries – Fast data retrieval
✅ Lazy Loading Components – Reduces initial load time
✅ API Caching (Optional) – Improves response speed

🎯 Bonus Features
✨ Dark Mode Toggle
✨ Ability to Save & Load Spreadsheets
✨ Data Visualization with Charts & Graphs (Planned)
✨ Enhanced UI with Tailwind CSS

📎 GitHub Repository
🔗 GitHub Link

📝 Author
👨‍💻 Developed By: Abubakar Chanda
📧 Email: abubakarchanda3@gmail.com

🚀 How to Contribute
Feel free to fork this repository and raise a pull request for improvements.

git clone https://github.com/your-repo-link-here.git
git checkout -b feature-branch
git commit -m "Added new feature"
git push origin feature-branch

🎉 Final Notes
This project was created as a Zeotap Software Engineer Intern Assignment. It mimics Google Sheets with a Java Full Stack implementation, offering spreadsheet functions, formula support, and a clean UI.

Thank you for checking out the project! 🙌