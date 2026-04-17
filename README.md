Quiz Backend API

A Spring Boot REST API for creating quizzes, fetching questions, and evaluating submitted answers.
Built using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL.

##Features
Create quiz with random questions
Fetch quiz questions without exposing correct answers
Submit quiz answers
Automatic score calculation
RESTful API architecture
MySQL database integration
Tech Stack
Java 21
Spring Boot
Spring Data JPA
Hibernate
MySQL
Maven

##Project Structure
src/main/java/com/quiz/quiz
│── Controller
│── Repo
│── entity
│── service
│── QuizApplication.java

##API Endpoints
1. Create Quiz
POST /quiz/getquiz/{numberOfQuestion}/{title}
Example
POST /quiz/getquiz/5/javaquiz
2. Get Quiz Questions
GET /quiz/{id}
Example
GET /quiz/1

Returns questions without correct answers.

3. Submit Quiz Answers
POST /quiz/submit/{id}
Example Request Body
[
  {
    "questionId": 10,
    "selectedOption": "B"
  },
  {
    "questionId": 4,
    "selectedOption": "A"
  }
]
Database Configuration

Create application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/questions
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Run Locally
Clone Repository
git clone https://github.com/your-username/QuizbackendAPI.git
cd QuizbackendAPI
Run Application
mvn spring-boot:run

Server starts at:

http://localhost:8080
Future Improvements
JWT Authentication
Timer based quiz
Leaderboard
User accounts
Frontend integration with React
Admin panel
Author

Sudhanshu Singh
