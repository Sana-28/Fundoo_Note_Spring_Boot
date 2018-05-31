package com.fundoonotes;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebMvcConfigurerAdapter {
	

	 protected void configure(HttpSecurity http) throws Exception {
	        http
	          .authorizeRequests()
	         .antMatchers("/home**").permitAll()
	         .antMatchers("/admin**").hasAnyRole("admin")
	         .and().formLogin();
	    }
	 @Bean
      public DataSource ds()
      {
		 DriverManagerDataSource dbms=new DriverManagerDataSource();
		 dbms.setDriverClassName("com.mysql.jdbc.Driver");
		 dbms.setUrl("jdbc:mysql://localhost:3306/Fundoo_DB");
		 dbms.setUsername("root");
		 dbms.setPassword("root");
		return dbms;
    	  
      }
	    protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("anil")
	            .password("rockstar")
	            .roles("admin");
	          /* auth.jdbcAuthentication()
	               .dataSource(ds())
	               .usersByUsernameQuery("select username,password, enabled from users where username=? and role=?");*/
	               
	    }
	   
}
