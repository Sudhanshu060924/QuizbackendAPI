# Quiz Backend API

A Spring Boot-based RESTful backend API for creating, retrieving, and submitting quizzes. This project is designed to manage quiz generation, question delivery, and answer evaluation using a MySQL database.

## 📖 Table of Contents

- Introduction
- Features
- Tech Stack
- API Endpoints
- Installation
- Database Configuration
- Run Locally
- Future Improvements
- Author

## 📌 Introduction

Quiz Backend API is a backend service built with Spring Boot that allows users to generate quizzes, retrieve questions, and submit answers.

## ✨ Features

- Create quizzes dynamically
- Fetch quiz questions securely
- Submit quiz answers for evaluation
- MySQL database integration

## 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## 📌 API Endpoints

### Create Quiz
POST `/quiz/getquiz/{numberOfQuestion}/{title}`

Example:
`POST /quiz/getquiz/5/javaquiz`

### Get Quiz Questions
GET `/quiz/{id}`

Example:
`GET /quiz/1`

Returns questions without correct answers.

### Submit Quiz Answers
POST `/quiz/submit/{id}`

Example Request Body:

```json
[
  {"questionId": 10, "selectedOption": "B"},
  {"questionId": 4, "selectedOption": "A"}
]
```

## ⚙️ Database Configuration

Create `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/questions
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## ▶️ Run Locally

```bash
git clone https://github.com/your-username/QuizbackendAPI.git
cd QuizbackendAPI
mvn spring-boot:run
```

Server starts at `http://localhost:8080`

## 🔮 Future Improvements

- JWT Authentication
- Timer based quiz
- Leaderboard
- User accounts
- React Frontend
- Admin Panel

## 👨‍💻 Author

Sudhanshu Singh


