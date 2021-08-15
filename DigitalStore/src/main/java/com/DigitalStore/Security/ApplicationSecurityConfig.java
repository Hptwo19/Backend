package com.DigitalStore.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PasswordEncoder passwordEncoder;
	
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder)
	{
		this.passwordEncoder=passwordEncoder;
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/")
		 .permitAll()
		 .anyRequest()
		 .authenticated()
		 .and()
		 .httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
			UserDetails adminUser = User.builder()
					.username("harshal")
					.password(passwordEncoder.encode("password"))
					.roles("ADMIN") //ROLE_ADMIN
					.build();
			
			return new InMemoryUserDetailsManager(adminUser);
	}

}
