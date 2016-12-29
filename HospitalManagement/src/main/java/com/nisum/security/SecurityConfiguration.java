package com.nisum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.config.annotation.web.configurers.ServletApiConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private CustomSuccessHandler customSuccessHandler;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobalSecurity");
		auth.userDetailsService(userDetailsService);
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		this.configureFilters(http);

		http.authorizeRequests().antMatchers("/", "/home", "/logout").permitAll().and().formLogin().loginPage("/login")
			.usernameParameter("uname").passwordParameter("pwd").successHandler(customSuccessHandler);
		
		
		
		http.authorizeRequests().antMatchers("/", "/home", "/logout").permitAll().antMatchers("/patientDetails").access("hasRole('ADMIN')").and().formLogin().loginPage("/login")
		.usernameParameter("uname").passwordParameter("pwd").successHandler(customSuccessHandler);
//		
//		http.authorizeRequests().antMatchers("/home").permitAll()
//	    .and().formLogin().loginPage("/login")
//		.usernameParameter("uname").passwordParameter("pwd")
//		// .defaultSuccessUrl("/userslist")
//		.successHandler(customSuccessHandler).and().logout().logoutSuccessUrl("/logout")
//		// .and().exceptionHandling().accessDeniedPage("/403")
//		.and().csrf().disable();
		
		
//		//new code
//		http.authorizeRequests()
//        .antMatchers("/").permitAll()
//       // .antMatchers("/admin/**").access("hasRole('ADMIN')")
//        //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//        .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
//        .usernameParameter("ssoId").passwordParameter("password")
//        .and().csrf()
//        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
//    
	}
	

	@SuppressWarnings("unchecked")
	private void configureFilters(HttpSecurity http) {
		http.removeConfigurer(HeadersConfigurer.class);
		http.removeConfigurer(RequestCacheConfigurer.class);
		http.removeConfigurer(DefaultLoginPageConfigurer.class);
		http.removeConfigurer(ServletApiConfigurer.class);
	}

}
