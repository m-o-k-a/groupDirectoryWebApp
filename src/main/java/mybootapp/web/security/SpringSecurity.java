package mybootapp.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	PersonRepository pr;
	
	@Autowired
	GroupRepository gr;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//
                .antMatchers("/", "/webjars/**", "/style.css",
                		 "/groups/**", "/persons/**", "/user/**")// "roupDirectoryWebApp/src\\main\\resources\\static"
                .permitAll()//
                // -- Les autres URL nécessitent une authentification
                .anyRequest().permitAll();//.denyAll();
    }
    
    /* Définir la base de l'authentification. */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        var encoder = passwordEncoder();
        auth.inMemoryAuthentication()//
                .withUser("admin").password(encoder.encode("admin")).authorities("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}