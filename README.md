<<<<<<< HEAD
# TravelPlanner API

**Description**  
Brief overview: what it does, main features, and tech stack (Java → Spring Boot, JPA, H2/MySQL, Security).

---

## 🚀 Features

- List/create/update Travel Destinations (`GET`, `POST`, `PUT`, etc.)
- Manage Interests (`POST /interests`, `GET /interests`)
- Security: Basic Auth, CSRF disabled (REST-friendly)

---

## 🛠️ Prerequisites

- Java 17+
- Maven
- MySQL (or H2 for testing)
- (Optional) Postman or curl for testing

---

## 📥 Installation & Setup

1. Clone the repo:
   ```bash
   git clone https://github.com/<YOUR_USER>/travelplanner.git
=======
# TravelPlanner

A Spring Boot backend application that helps users plan trips, manage itineraries, and explore travel routes.

## 🚀 Features

- REST API endpoints for creating and retrieving trips and itineraries
- Integration with MySQL (JPA) for data storage
- Spring Security (optional) for authentication
- Configuration via `application.properties`

## 🛠️ Prerequisites

- Java 17+ installed
- Maven installed
- MySQL running with the `travelplanner` database created
- Environment variables set for `spring.datasource.username` and `spring.datasource.password`

## 💾 Setup & Run Locally

```bash
git clone https://github.com/<your-username>/travelplanner.git
cd travelplanner
# Optional: update DB credentials in application.properties or via env vars
mvn clean install
mvn spring-boot:run
>>>>>>> 7a69ea6439c5710a8d5ca3c96cb9045be2b19c71
