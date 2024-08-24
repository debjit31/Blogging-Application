# Blogging Application

A modern blogging application built using Spring Boot, Spring Data JPA, and Spring Security. This project features user authentication and authorization with custom roles, a responsive user interface with Thymeleaf, and is fully dockerized and deployed on AWS.

## Features

- **User Authentication & Authorization**: Secure login and access control with Spring Security. Utilizes `DaoAuthenticationProvider` for form-based authentication and custom roles for user management.
- **Backend**: Implemented using Spring Boot and Spring Data JPA for robust data management.
- **Frontend**: Integrated Thymeleaf templates for a clean UI. (Note: React or Angular can be used for an alternative frontend.)
- **Database**: PostgreSQL for reliable and scalable data storage. Utilizes a free tier RDS instance on AWS.
- **Docker**: Containerized application for consistent deployment and easy scaling.
- **Deployment**: Deployed on an AWS instance.

## Technologies Used

- **Spring Boot**: For creating stand-alone, production-grade Spring-based applications.
- **Spring Data JPA**: Simplifies database interactions with JPA repositories.
- **Spring Security**: Provides authentication and authorization capabilities.
- **Thymeleaf**: Server-side Java template engine for rendering web pages.
- **PostgreSQL**: Open-source relational database.
- **Docker**: Containerization platform for deploying applications.
- **AWS**: Cloud services provider for hosting and managing the application and database.

## Getting Started

### Prerequisites

- Java 11 or higher
- Docker
- PostgreSQL

### Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/blogging-application.git
   cd blogging-application
   ```

2. **Configure Database:**
   
   - Set up a PostgreSQL instance and create a database.
   - Update `application.properties` with your database credentials.

3. **Build and Run:**

   ```bash
   ./gradlew build
   docker-compose up
   ```

4. **Access the Application:**
   
   Open your browser and navigate to `http://localhost:8080`.

## Deployment

The application is pre-configured for deployment on AWS. You can deploy the Docker image to an AWS instance and connect it to a PostgreSQL RDS instance for production use.

## Contributing

Feel free to submit issues or pull requests to improve the application. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please contact [your-email@example.com](mailto:your-email@example.com).

---

Feel free to modify any sections according to your specific needs or preferences!
