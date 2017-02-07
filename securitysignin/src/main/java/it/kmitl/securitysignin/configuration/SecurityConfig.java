package it.kmitl.securitysignin.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("teacher").password("12345").roles("TEACHER");
        auth.inMemoryAuthentication().withUser("staff").password("12345").roles("STAFF");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')")
                .antMatchers("/staff/**").access("hasRole('ROLE_STAFF')")
                .and()
                .formLogin().loginPage("/user/sign-in")
                .defaultSuccessUrl("/teacher/home")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/user/sign-in?out")
                .and().csrf();
    }
}