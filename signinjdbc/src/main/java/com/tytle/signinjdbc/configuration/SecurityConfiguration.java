package com.tytle.signinjdbc.configuration;

import com.tytle.signinjdbc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.tytle.signinjdbc")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // DATABASE AUTHENTICATION
        auth.userDetailsService(authenticationService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/graduate-student/**").hasRole("GRADUATE_STUDENT")
                .antMatchers("/teacher/**").hasRole("TEACHER")
                .antMatchers("/staff/**").hasRole("STAFF")
                .anyRequest().authenticated()
                .and().formLogin()
                    .loginPage("/user/sign-in").permitAll()
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/user/sign-in", true)
                    .failureUrl("/user/sign-in?error=true")
                .and().logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/user/sign-in")
                    .invalidateHttpSession(true)
                .and().csrf();
    }
}