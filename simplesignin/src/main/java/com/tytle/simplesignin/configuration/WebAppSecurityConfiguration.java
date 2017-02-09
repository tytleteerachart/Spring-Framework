package com.tytle.simplesignin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebAppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
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
                    .invalidateHttpSession(true);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("teacher").password("1150").roles("TEACHER").and()
                .withUser("staff").password("1150").roles("STAFF");
    }
}