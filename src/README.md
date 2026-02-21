# API Tests for JSONPlaceholder

A tutorial project for learning API testing.

## Tech Stack
- Java 21
- Gradle
- JUnit 5
- REST Assured
- Jackson
- Allure Reports

## 🏗 Project Structure
- **POJO Models** — Java objects matching JSON responses (`User`, `Address`, etc.)
- **API Clients** — Encapsulate HTTP requests (`UserClient`)
- **Test Data** — Predefined objects for tests (`UserTestData`)
- **Custom Assertions** — Reusable validations (`UserAssertions`)
- **Tests** — Organized by endpoint (`/users`, `/posts`)

## Running Tests
```bash
./gradlew test