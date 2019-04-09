package br.com.ayranandrade.pseudotinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.ayranandrade.pseudotinder.helpers.CustomPasswordEncoder;
import br.com.ayranandrade.pseudotinder.services.DefaultLoginService;

@SpringBootApplication
@EnableWebSecurity
public class Application extends WebSecurityConfigurerAdapter implements CommandLineRunner {

	@Autowired
	private DefaultLoginService loginService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Application available in http://localhost:8080");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.and()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/favicon.ico").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/register/one", false)
		.failureUrl("/?error=true")
		.and()
		.logout()
		.logoutUrl("/logout")
		.deleteCookies("JSESSIONID");
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(loginService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new CustomPasswordEncoder();
	}

}
