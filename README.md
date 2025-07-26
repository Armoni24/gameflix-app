# GameFlix Backend – Dockerized

This project is a Spring Boot backend for GameFlix that has been containerized using Docker.  
You can run it as a standalone container or with Docker Compose (recommended, includes MySQL).

---

## **Requirements**
- Docker Desktop installed
- (Optional) Docker Compose if you want MySQL running with it

---

## **Build and Run without Compose**

### 1. Build the Docker image
```bash
docker build -t gameflix-backend .