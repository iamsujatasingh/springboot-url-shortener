# springboot-url-shortener
# 🔗 Short URL Generator

This is a simple Spring Boot application that generates short URLs for long links, similar to services like Bitly.

## ✨ Features
- Generate random 7-character short URLs
- Save URL mappings to in-memory H2 database
- Automatically avoid duplicate short URLs
- Redirect from short URL to original long URL

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database

## ⚙️ Endpoints

| Method | URL | Description |
|:------|:----|:------------|
| `POST` | `/url/create` | Create a short URL from a long URL |
| `GET` | `/url/fetch/{shortUrl}` | Fetch original long URL from short URL |

## 📋 API Usage

### Create Short URL

```bash
POST /url/create
Content-Type: application/json

{
  "longUrl": "https://www.example.com/very-long-link"
}
