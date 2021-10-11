package ru.gb.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        ru.gb.conf.User user=new ru.gb.conf.User();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username(user.getAdminLoggin()).password(user.getAdminPassword()).roles(user.getAdminRights()))
                .withUser(userBuilder.username(user.getUserLoggin()).password(user.getUserPassword()).roles((user.getUserRights())));
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//непонятная вещь из-за которой все заработало

        ru.gb.conf.User user=new ru.gb.conf.User();


        http.authorizeRequests()
                .antMatchers("/").hasAnyRole(user.getUserRights())
                .antMatchers("/products/admin/**").hasRole(user.getAdminRights())
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }


}
