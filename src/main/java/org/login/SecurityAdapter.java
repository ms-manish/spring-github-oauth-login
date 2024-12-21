package org.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index.html").permitAll() // Allow unauthenticated access to these endpoints
                .anyRequest().authenticated()              // Secure all other endpoints
                .and()
                .oauth2Login()
                .defaultSuccessUrl("/welcome", true)       // Redirect to /welcome after successful login
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)) // Handle unauthorized access
                .and()
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Enable CSRF with HttpOnly disabled for token
                .and()
                .logout()
                .logoutSuccessUrl("/logout").permitAll();  // Allow unauthenticated access to /logout
    }
}