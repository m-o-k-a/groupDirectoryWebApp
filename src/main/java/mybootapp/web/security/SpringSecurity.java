package mybootapp.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        		.authorizeRequests().antMatchers("/login").permitAll()
				.and()
                // -- URL sans authentification
                .authorizeRequests()//
                .antMatchers("/", "/webjars/**", "/src/main/ressources/**", //
                		 "/static/**", "/home", "/login")//
                .permitAll()//
                // -- Les autres URL nécessitent une authentification
                .anyRequest().authenticated()
                // -- Nous autorisons un formulaire de login
                .and().formLogin().permitAll()
                .and().formLogin().permitAll() //loginPage("/login")
                // -- Nous autorisons un formulaire de logout
                .and().logout().permitAll();
    }
    
    /* Définir la base de l'authentification. */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        var encoder = passwordEncoder();
        auth.inMemoryAuthentication()//
                .withUser("user1").password(encoder.encode("user1")).authorities("USER")//
                .and()//
                .withUser("user2").password(encoder.encode("user2")).authorities("USER")//
                .and()//
                .withUser("admin").password(encoder.encode("admin")).authorities("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}