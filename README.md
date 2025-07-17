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
