package org.role.based.auth.jwt.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

// web security configuration 

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private UserDetailsService jwtService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    //@PreAuthorize("hasRole('USER')")
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
   	  
        http.cors();
        http.csrf().disable()
        
        
                .authorizeRequests().antMatchers("/authenticate", "/registerNewUser").permitAll()
               
                // to skip authorization below code has to uncomment  
                // for undergoing authorization the below code has to comment 
                
                .antMatchers(
               		"/upload/image/data",
               		"/create/movie",
                "/update/user",
                "/delete-user/{userName}",
                "/create/comment",
                "/search-for-comments",
               		"/super6/create/comment",
               		"/super6/create/comment",
                		"/super6/comments",
                		"/super6/update/comment/{id}",
                		"http://localhost:8761/eureka",
                		"/currently-in-theatres",
               		"/update/data/{id}",
                		"/update/movie/{id}", 
                		"/trending-movies",
                		"list-all-users",
                		"/theatre-movies",
                		"/watch-movie/{id}",
                		"/search-fields",
                		"/super6/delete/comments/{id}",
                		"/update/{id}",
                		"/update-movie/{id}",
                		"/movies/{id}",
                		"/best-movies",
                		"/get/image/info/{filename}",
                		"/get/image/{filename}",
                		"/all-movies-for-admin",
                		"/all-movies", 
                		"/all-images",
                		"/all-images/{id}",
                		"/movies/{id}/comments"
                		).permitAll()
                
                .antMatchers("v3/api/docs").permitAll().antMatchers(HttpMethod.GET).permitAll()
                
                .antMatchers(HttpHeaders.ALLOW).permitAll()
              
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        
        
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(jwtService).passwordEncoder(passwordEncoder());
    }
}
