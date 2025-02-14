# Student Management System

## 📌 Overview
This is a **Spring Boot** application for managing students, using **Hibernate (JPA)** for ORM and **Flyway** for database migrations. It interacts with a **PostgreSQL** database to store and manage student records.

## 🚀 Features
- **CRUD Operations** for students (Create, Read, Update, Delete)
- **Spring Data JPA** for database interaction
- **Flyway for database migrations**
- **PostgreSQL as the database**
- **Spring Boot RESTful API**

## 📂 Project Structure
```
student-management/
├── src/
│   ├── main/
│   │   ├── java/com/flexisaf/student_management/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── StudentManagementApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   ├── db/
│   │   │   │   ├── migration/
│   │   │   │   │   ├── V1__Create_Student_Table.sql
│   ├── test/
│   ├── pom.xml
```

## 🛠 Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Flyway Migration**
- **Maven**

## 🔧 Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/student-management.git
cd student-management
```

### 2️⃣ Configure Database
Update **`src/main/resources/application.properties`** with your PostgreSQL details:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=none
spring.flyway.enabled=true
```

### 3️⃣ Run Database Migration
Ensure Flyway runs the migration by starting the application:
```bash
mvn spring-boot:run
```
Or use:
```bash
./mvnw spring-boot:run
```

### 4️⃣ Verify Database Migration
Login to PostgreSQL and check if the **students** table exists:
```sql
\c student_db;
\dt;
SELECT * FROM flyway_schema_history;
```

## 🏗 API Endpoints
| Method | Endpoint         | Description        |
|--------|----------------|------------------|
| GET    | /students       | Get all students |
| GET    | /students/{id}  | Get a student by ID |
| POST   | /students       | Create a student |
| PUT    | /students/{id}  | Update student |
| DELETE | /students/{id}  | Delete student |

## 📜 Example Student Entity (Hibernate)
```java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    private String course;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String gender;
    private String address;
    private boolean isActive = true;
    
    // Getters & Setters
}
```

## 🛠 Repository Interface
```java
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByCourse(String course);
}
```

## ✅ License
This project is **MIT Licensed**.

## 🤝 Contributing
Feel free to submit **issues** or **pull requests**.

---
**Happy Coding! 🚀**
