# AI Text Generation REST API

A Java-based REST API built with **Spring Boot** to interface with a **locally hosted LLM using Ollama**, enabling dynamic text generation via HTTP endpoints.

This project demonstrates a **clean controller-service architecture**, request validation, structured JSON responses, and error handling — making it production-ready and interview-worthy.

---

## Table of Contents

* [Features](#features)
* [Tech Stack](#tech-stack)
* [Setup](#setup)
* [Running the App](#running-the-app)
* [API Usage](#api-usage)
* [Swagger UI](#swagger-ui)
* [Project Structure](#project-structure)
* [Future Improvements](#future-improvements)

---

## Features

* Generate text from a prompt using a **local Ollama LLM**
* **Controller–Service architecture** following OOP principles
* Request validation with `@Valid` and `@NotBlank`
* Structured JSON responses (`TextRequest` / `TextResponse`)
* Global exception handling for cleaner error messages
* Interactive API docs via **Swagger UI**

---

## Tech Stack

* Java 17
* Spring Boot 3.x
* Maven
* Ollama (local LLM runtime)
* Swagger / OpenAPI (Springdoc)

---

## Setup

### Prerequisites

* [Java 17](https://adoptium.net/)
* [Maven](https://maven.apache.org/download.cgi)
* [Ollama](https://ollama.com)

### Steps

1. Clone the repository:

```bash
git clone <your-repo-url>
cd ai-text-api
```

2. Start the Ollama local LLM:

```bash
ollama run llama3.2
# or
ollama serve
```

3. Build and run the Spring Boot app:

```bash
mvn spring-boot:run
```

4. Open the app in your browser:

```
http://localhost:8080
```

Whitelabel error page means Spring Boot is running ✅

---

## API Usage

**POST** `/api/generate`

**Request Body**:

```json
{
  "prompt": "Explain REST APIs in simple terms",
  "model": "llama3.2"
}
```

**Response**:

```json
{
  "model": "llama3.2",
  "prompt": "Explain REST APIs in simple terms",
  "generatedText": "A REST API is..."
}
```

---

## Swagger UI

Swagger provides interactive API documentation. Access it at:

```
http://localhost:8080/swagger-ui.html
```

You can test endpoints directly from the Swagger interface.

---

## Project Structure

```
ai-text-api
├── src/main/java/com/example/aitextapi
│   ├── controller
│   │   └── TextGenerationController.java
│   ├── service
│   │   └── OllamaService.java
│   ├── dto
│   │   ├── TextRequest.java
│   │   └── TextResponse.java
│   └── exception
│       ├── GlobalExceptionHandler.java
│       └── ApiError.java
├── pom.xml
└── README.md
```

---

## Future Improvements

* Add **streaming responses** from Ollama
* Move Ollama URL to `application.yml` for config flexibility
* Add **authentication** for API access
* Write **unit & integration tests**
* Dockerize the API for containerized deployment
* Add logging and request-response timing metrics

---

## Author

**Sai Pranav Nishtala**
saipranavnishtala.com
