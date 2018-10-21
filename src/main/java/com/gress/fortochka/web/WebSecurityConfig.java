package com.gress.fortochka.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

/**
 * @author Roman_Radetskiy.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/adm/*")
                .fullyAuthenticated()

                .and()
                .formLogin().loginPage("/adm").permitAll()

                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .permitAll()

                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")

                .and()
                .csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("admin");
        /*auth.ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");*/
    }}
