package com.example.HireMe;

import com.example.HireMe.Service.LocalUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final LocalUserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(LocalUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        TimpassAuthFiler filter = new TimpassAuthFiler();
        filter.setAuthenticationManager(this.testAuthenticationManager());
        http.authorizeRequests()
                .antMatchers("/applicants/dashboard").authenticated()
                .antMatchers("/applicants/**").permitAll()
                .antMatchers("/applicants/dashboard").hasRole("APPLICANT")
                .antMatchers("/user/**").hasRole("APPLICANT")
                .antMatchers("/org/**").hasRole("ORGANISATION")



                .antMatchers("/organisation/**").permitAll()
                .antMatchers("/api/v1/files/upload").permitAll()


                .antMatchers("/styles/**").permitAll() // URLs that are accessible without authentication
                .antMatchers("/icon/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/applicants/login")
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied"); // Custom access denied page
    }

    @Bean
    public TestAuthenticationManager testAuthenticationManager(){
        return new TestAuthenticationManager(this.userDetailsService);
    }
}
