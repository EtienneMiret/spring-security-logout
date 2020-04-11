Sample for [spring-projects/spring-security#8375][1].

Reproduction steps:
 1. Build this project with `./gradlew assemble` (requires Java 13)
 2. Deploy the generated `build/libs/spring-security-logout-1.0.0-SNAPSHOT.war`
    to your favorite container.
 3. Navigate to where you deployed (say http://localhost:8080/)
 4. The home page will tell you are NOT authenticated.
 5. Navigate to the `/login` page.
 6. Authenticate with user:user credentials.
 7. The home page will now tell you DO are authenticated.
 8. Navigate to the `/logout` page and confirm.
 9. Go back to the home page: it says you are still authenticated.

[1]: https://github.com/spring-projects/spring-security/issues/8375
