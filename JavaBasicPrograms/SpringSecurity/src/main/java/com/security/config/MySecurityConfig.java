package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.security.security.CustomAuthenticationProvider;
import com.security.security.CustomUserDetailsService;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private CustomAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	// customise http request
//		http
//		.authorizeRequests()
//		.antMatchers("/dashboard").authenticated()
//		.antMatchers("/home").permitAll()
//		.and()
//		.formLogin()
//		.and()
//		.httpBasic();

//	 deny request so all can access
//		 http.authorizeRequests()
//		.anyRequest().denyAll()
//		.and()
//		.httpBasic();

//		http.authorizeRequests()
//		.antMatchers("/user/**").permitAll()
//		.antMatchers("/admin/**")
//		.denyAll()
//		.and()
//		.httpBasic();

//		http
//		.authorizeRequests()
//		.antMatchers("/user/home").permitAll()
//		.antMatchers("/user/dashboard").authenticated()
//		.and()
//		.httpBasic();

		// encode the password
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/register", "/login").permitAll()
		.antMatchers("/dashboard").hasAnyAuthority("READ")
		.antMatchers("/profile").hasAnyAuthority("WRITE")
		.and()
		.httpBasic();

	}
//normal
//@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("sridhar").password("123").authorities("admin")
//		.and().withUser("asu").password("345").authorities("user")
//		.and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//		
//	}

//by using userdetailsservice
//@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager userDetailsService =new InMemoryUserDetailsManager();
//		UserDetails user1=User.withUsername("sridhar").password("123").authorities("admin").build();
//		UserDetails user2=User.withUsername("asu").password("345").authorities("user").build();
//		userDetailsService.createUser(user1);
//		userDetailsService.createUser(user2);
//		auth.userDetailsService(userDetailsService);
//	}

	
	
//by using customUserdetailsService
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//userDetailsServiceProvider
		// auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

		// customAuthenticationProvider
		auth.authenticationProvider(authenticationProvider);
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

}
