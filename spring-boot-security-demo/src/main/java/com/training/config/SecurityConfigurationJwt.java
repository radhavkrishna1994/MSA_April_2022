package com.training.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationJwt extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder myPasswordEncoder()
	{
		return new PasswordEncoder() {

			@Override
			public String encode(CharSequence rawPassword) {
				
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				System.out.println(rawPassword+" "+encodedPassword);
				if(rawPassword.equals(encodedPassword))
					return true;
				return false;
			}
			
		};
	}
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//Authentication
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(myPasswordEncoder());
	}

	// Authorization
	public void configure(HttpSecurity http) throws Exception
	{
			http
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/authenticate")
			.permitAll()
			.antMatchers("/user/**")
		//	.hasRole("USER")
			.hasAnyRole("USER","ADMIN")
			.antMatchers("/admin")
			.hasRole("ADMIN")
			.anyRequest()
			.authenticated();
			
	}
	@Bean
	public AuthenticationManager authManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
