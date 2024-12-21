# spring-github-oauth-login
Spring Boot project for OAuth login with GitHub

Simple starter for a Spring Boot Web application with GitHub OAuth support.

Steps:
1. Create a GitHub App and get the Client ID and Client Secret values. (Specify callback URL as `http://localhost:8080/login/oauth2/code/github` for development)
2. Add those values in `application.properties or yml file`
3. Run the Spring Boot App. It will redirect you to GitHub login page.
4. After successful login , you will get one welcome page.