package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration{

//	private static final String[] WHITE_LIST_URLS = { "/hello", "/register" };

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .cors() // Enable CORS configuration if needed
//            .and()
//            .csrf().disable() // Disable CSRF protection
//            .authorizeRequests()
//                .antMatchers("/public/**").permitAll() // Allow public access
//                .antMatchers("/private/**").authenticated() // Require authentication for private URLs
//            .anyRequest().authenticated() // Require authentication for any other URL
//            .and()
//            .formLogin() // Configure form-based login if neededF
//                .loginPage("/login")
//                .defaultSuccessURL("/dashboard")
//            .and()
//            .logout() // Configure logout if needed
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//            .and()
//            .httpBasic(); // Enable HTTP Basic authentication if needed
//    }

//	@Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .antMatchers(WHITE_LIST_URLS).permitAll();
//            return http.build();
//    }
	
}
