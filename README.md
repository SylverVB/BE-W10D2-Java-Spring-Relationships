# 🎵 Spring Relationships: Music Management App

A Spring Boot application demonstrating the use of **JPA relationships** (One-to-Many and Many-to-One) between three core entities: `Artist`, `Album`, and `Song`. It showcases best practices in ORM mapping, entity design, and service-based architecture with test support using JUnit and Mockito.

---

## 🚀 Features

* **Entity Relationships**:

  * An **Artist** can have many **Albums**.
  * An **Album** belongs to one **Artist** and can contain many **Songs**.
  * A **Song** belongs to one **Album**.

* **Service Layer**:

  * Add and retrieve Artists, Albums, and Songs.
  * Associate Albums with Artists and Songs with Albums.

* **Testing**:

  * Unit tests using JUnit 5.
  * Reflection-based tests to validate entity annotations and relationships.

* **In-Memory Database**:

  * Uses H2 for easy development and testing.

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* H2 Database
* Lombok
* JUnit 5 & Mockito

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/com/app/
│   │   ├── Model/
│   │   │   ├── Artist.java       # Artist entity (1:N to Album)
│   │   │   ├── Album.java        # Album entity (N:1 to Artist, 1:N to Song)
│   │   │   └── Song.java         # Song entity (N:1 to Album)
│   │   ├── Repository/
│   │   │   ├── ArtistRepository.java
│   │   │   ├── AlbumRepository.java
│   │   │   └── SongRepository.java
│   │   ├── Service/
│   │   │   ├── ArtistService.java
│   │   │   ├── AlbumService.java
│   │   │   └── SongService.java
│   │   └── Application.java      # Main class (bootstraps data)
│
└── test/
    └── java/com/app/
        └── EntityTest.java       # JUnit tests to validate entity relationships
```

---

## ⚙️ Setup Instructions

### Prerequisites

* Java 21+
* Maven 3.8+

### Steps to Run

1. **Clone the Repository**

   ```bash
   git clone https://github.com/SylverVB/BE-W10D2-Java-Spring-Relationships.git
   cd BE-W10D2-Java-Spring-Relationships
   ```

2. **Build and Run the App**

   ```bash
   mvn spring-boot:run
   ```

3. **Access the H2 Console**

   Navigate to `http://localhost:8080/h2-console`

   * **JDBC URL**: `jdbc:h2:mem:testdb`
   * **Username**: `sa`
   * **Password**: *(leave blank)*

---

## ✅ Testing

Run the unit tests with:

```bash
mvn test
```

Tests are located in `src/test/java/com/app/EntityTest.java` and validate the correct use of `@ManyToOne` and `@OneToMany` annotations using reflection.

---

## 📦 Dependencies Overview

* `spring-boot-starter-web` – RESTful web support (optional)
* `spring-boot-starter-data-jpa` – ORM and data persistence
* `h2` – In-memory database for development/testing
* `lombok` – Reduces boilerplate Java code
* `spring-boot-starter-test` – Testing support
* `mockito-core` – Mocking library for unit tests

---

## ✨ Example Usage

In `Application.java`:

```java
Artist artist = new Artist("The Beatles");
Album album = new Album("Abbey Road");
Song song = new Song("Come Together");

artistService.addArtist(artist);
albumService.addAlbum(album);
songService.addSong(song);

artistService.addAlbumToArtist(artist.getId(), album);
albumService.addSongToAlbum(album.getId(), song);
```

---

## 📖 Learnings

* Implementing One-to-Many and Many-to-One relationships with JPA
* Using Lombok for concise Java code
* Writing reflection-based tests to validate entity design
* Managing service-layer operations with Spring Boot and JPA

---

## 🛠 Build & Run

### Requirements

* Java 21
* Maven 3.8+

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

---

## 🔍 Testing

Run tests with:

```bash
mvn test
```

Includes:

* Unit test coverage for `@Transactional` configuration.
* Integration-level demonstration via `main()` method output.

---

## 📚 Documentation Reference

* **Spring `@Transactional`**:

  * Ensures atomic method execution.
  * Supports rollback for unchecked and explicitly declared checked exceptions.

---

## 📌 Notes

* Lombok must be properly configured in your IDE to prevent compilation issues.
* Uses H2 in-memory DB by default for testing and development.
* The `main()` method uses a brief `Thread.sleep(500)` to ensure Spring Boot context readiness.

---

## 👨‍💻 Author

Crafted to illustrate transactional boundaries and business-rule-based service interactions using Spring Boot and Java 21.