package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class Configures extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
	//	auth.inMemoryAuthentication().withUser("abc").password("{noop}abc").authorities("cust");
		//auth.inMemoryAuthentication().withUser("def").password("{noop}def").authorities("manager");
		
		auth.inMemoryAuthentication().withUser("abc").password("{noop}abc").roles("cust");
		auth.inMemoryAuthentication().withUser("def").password("{noop}def").roles("manager");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/offers").authenticated()
//		.antMatchers("/balance").hasAnyAuthority("cust","manager")
//		.antMatchers("/loanApprove").hasAuthority("manager").anyRequest().authenticated()
		
		.antMatchers("/balance").hasAnyRole("cust","manager")
		.antMatchers("/loanApprove").hasRole("manager").anyRequest().authenticated()
		.and().httpBasic()
		.and().formLogin()	
		.and().rememberMe()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.and().exceptionHandling().accessDeniedPage("/access")
		.and().sessionManagement().maximumSessions(3).maxSessionsPreventsLogin(true);
	}
}
