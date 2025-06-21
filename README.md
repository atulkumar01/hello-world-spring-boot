# Hello World Spring Boot

Simple REST API (Hello World) built with Spring Boot.

## Features

This application provides several REST endpoints to practice handling requests, responses, and common errors (like port conflicts). No database is required.

## Endpoints

- **GET `/api/hello`**  
  Returns a hello message.

- **GET `/api/greet?name=yourName`**  
  Greets a user by name (provided as a query parameter).

- **GET `/api/square/{number}`**  
  Calculates and returns the square of a number (provided as a path variable).

- **GET `/api/grade?marks=yourMarks`**  
  Returns a grade based on the marks (provided as a query parameter).

- **GET `/api/format-date?date=yyyy-MM-dd`**  
  Formats a date from the input (provided as a query parameter).

- **GET `/api/user/{id}?info=type`**  
  Combines a path variable and a query parameter in one endpoint.

---

Let me know if you want to add installation instructions, usage examples, or any other content!
