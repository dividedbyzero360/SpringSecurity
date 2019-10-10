package com.luv2code.springsecurity.demo.config;


import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add our users for in memory authentication

        UserBuilder users = User.withDefaultPasswordEncoder();

//        auth.inMemoryAuthentication()
//                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//                .withUser(users.username("mary").password("test123").roles("MANAGER"))
//                .withUser(users.username("susan").password("test123").roles("ADMIN"))
//                .withUser(users.username("susan1").password("test123").roles("USER"));


//        auth.inMemoryAuthentication()
//                .withUser("john").password("{noop}test123").roles("USER");
        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE","MANAGER","ADMIN","USER"))
                .withUser(users.username("mary").password("test123").roles("MANAGER"))
                .withUser(users.username("susan").password("test123").roles("ADMIN"))
                .withUser(users.username("susan1").password("test123").roles("USER"));
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests().antMatchers("/").access("hasRole('User')")
//                .and().formLogin() .permitAll()
//                .and()
//        ;

        http.authorizeRequests().anyRequest().authenticated().and().csrf().disable().formLogin().loginProcessingUrl("/acct/signin11").defaultSuccessUrl("/", true);
//        http.authorizeRequests()
//                .anyRequest().authenticated().and().httpBasic()
//              ;
//        http.formLogin().defaultSuccessUrl("/").and().csrf().disable();

//       super.configure(http);
//       http.authorizeRequests().anyRequest().authenticated().
//       http.formLogin().defaultSuccessUrl("/").and().csrf().disable();
////                .formLogin()
////                .and()
////                .authorizeRequests()
////                .antMatchers("/").hasRole("USER")
////                .antMatchers(HttpMethod.POST, "/").hasRole("USER")
////                .and()
////                .csrf().disable();
//
    }


//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().anyRequest();
//    }


}






