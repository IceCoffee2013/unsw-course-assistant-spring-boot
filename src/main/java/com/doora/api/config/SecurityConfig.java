package com.doora.api.config;


import com.doora.api.filters.StatelessLoginFilter;
import com.doora.api.security.TokenAuthenticationService;
import com.doora.api.filters.StatelessAuthenticationFilter;
import com.doora.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * url filter & auth.
 */
@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public SecurityConfig() {
        super(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        //h2 database console
        http.headers().frameOptions().disable();

        http.exceptionHandling()
            .and().anonymous()
            .and().servletApi()
            .and().headers().cacheControl();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/posts/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/posts/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/users").authenticated()
                .antMatchers(HttpMethod.GET, "/api/course").permitAll()
                .antMatchers(HttpMethod.POST, "/api/course/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/course/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/course/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/question").permitAll()
                .antMatchers(HttpMethod.POST, "/api/question/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/question/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/question/**").authenticated()
                .antMatchers(HttpMethod.GET, "/api/answer").permitAll()
                .antMatchers(HttpMethod.POST, "/api/answer/**").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/answer/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/answer/**").authenticated()
                .antMatchers(HttpMethod.GET, "/console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/register").permitAll()
                .antMatchers("/api/admin/**").hasRole("ADMIN");

        http.addFilterBefore(
                new StatelessLoginFilter("/api/login", tokenAuthenticationService, userService, authenticationManager()),
                UsernamePasswordAuthenticationFilter.class);

        http.addFilterBefore(
                new StatelessAuthenticationFilter(tokenAuthenticationService),
                UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }
}