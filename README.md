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

## 📁 Project Structure

```plaintext
springboot-url-shortener/
├── src/main/java/com/susin/shorturlapp/
│   ├── controller/
│   │   └── UrlShorteningController.java
│   ├── dao/
│   │   └── UrlShortRepository.java
│   ├── model/
│   │   └── UrlRecord.java
│   │   └── UrlRequest.java
│   └── service/
│       └── UrlShortService.java
├── src/main/resources/
│   ├── application.properties
├── .gitignore
├── README.md
├── pom.xml

## ⚙️ Endpoints

| Method | URL | Description |
|:------|:----|:------------|
| `POST` | `/api/createShortUrl` | Create a short URL for the provided long URL |
| `GET` | `/api/fetchLongUrl?shortUrl={shortUrl}` | Redirect to the original long URL |
## 📋 API Usage

## 💾 URLRequest POJO Class

The `UrlRequest` POJO class handles the **long URL** input from the user.

```java
public class UrlRequest {
    private String longUrl;

    // Getter and Setter
    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
### Create Short URL

```bash
POST /url/create
Content-Type: application/json

{
  "longUrl": "https://www.example.com/very-long-link"
}
