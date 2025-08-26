# 🔗 Shorty – Java URL Shortener

![CI](https://github.com/PlatoCode13/shorty/actions/workflows/ci.yml/badge.svg)

A lightweight **URL shortener** built with **Spring Boot 3** and **Java 17**.  
This project demonstrates clean software engineering practices: **REST APIs**, **validation & error handling**, **unit testing (JUnit 5)**, and **CI/CD with GitHub Actions**.

---

## ✨ Features
- **Shorten URLs** → `POST /api/urls`  
  Example request:
  ```json
  { "url": "https://example.com" }

Example response:
  ```json
{ "code": "abc123", "shortUrl": "http://localhost:8080/r/abc123" }
````
Redirect → GET /r/{code} → HTTP 302 redirect to original URL.

Health check → GET /api/urls/health → { "status": "ok" }.

Simple front-end at / for easy testing in the browser.

# Run locally
Prerequisites

Java 17+ (works with Java 21 too)

Maven 3.9+ (or just use the Maven Wrapper included)

Run the app 
```
./mvnw spring-boot:run
```

Then open:
``` 
http://localhost:8080
```

🧪 Test

Run the JUnit test suite:

./mvnw test

⚙️ CI/CD

Every push runs on GitHub Actions:

Builds the project

Runs all tests

Ensures the wrapper is valid (./mvnw)

Badge:

📸 Demo

The project includes a small web page (index.html) for testing.

Go to http://localhost:8080
.

Enter a URL → click Shorten.

Get a clickable short link.


<img width="2382" height="963" alt="image" src="https://github.com/user-attachments/assets/aa2b1c19-2ea9-4604-8b8a-76b0ab3d26d9" />





🛠️ What I Learned

Building a REST API in Java + Spring Boot.

Designing services with separation of concerns (DTOs, core logic, controllers).

Error handling with @RestControllerAdvice.

Writing tests with JUnit 5.

Using Git & GitHub Actions CI to automate builds/tests.

Deploy-ready project structure (Maven Wrapper, .gitignore, workflow).
