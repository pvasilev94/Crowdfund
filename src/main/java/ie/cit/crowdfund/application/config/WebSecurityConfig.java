package ie.cit.crowdfund.application.config;

import ie.cit.crowdfund.application.entity.User;
import ie.cit.crowdfund.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                    .authorizeRequests()
//                    .antMatchers("/", "/home").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                     .loginPage("/signin")
//                     .defaultSuccessUrl("/homeSignedIn")
//                     .permitAll()
//                     .and()
//                .logout()
//                     .permitAll();
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user.getFullName());
            auth
                    .inMemoryAuthentication()
                    .withUser(user.getEmail()).password(user.getPassword()).roles("ADMIN");
        }
    }
    //ignore authentication for resources;
    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/resources/**");
    }
}