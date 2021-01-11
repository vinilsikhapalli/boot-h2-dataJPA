package com.test.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurstion extends WebSecurityConfigurerAdapter{

	@Autowired
	javax.sql.DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception{
//		builder.inMemoryAuthentication().withUser("vinil").password("vinil").roles("USER")
//			.and().withUser("suba").password("suba").roles("ADMIN");
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.withDefaultSchema()
		.withUser(
				User.withUsername("vinil")
				.password("vinil")
				.roles("ADMIN")
				);
	}
	
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeRequests()
		.antMatchers("/product").hasAnyRole("ADMIN")
		.antMatchers("/").permitAll()
		.and()
		.formLogin();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		//return NoOpPasswordEncoder.getInstance();
		return null;
	}
	
}
