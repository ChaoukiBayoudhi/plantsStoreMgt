package tn.isg.mppsi.plantsStoreMgt.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.isg.mppsi.plantsStoreMgt.Services.UserService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userServ;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/h2-console/**").permitAll();
//
//        http.csrf().disable();
//        http.headers().frameOptions().disable();
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin").password("admin").authorities("ADMIN");
//        auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("chaouki").password("chaouki").authorities("USER");

        auth.userDetailsService(userServ).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/home")
                .hasRole("ADMIN")
                .antMatchers("/api/product/*")
                .hasRole("ADMIN")
                .and()
                .formLogin();
        //desactivate CSRF token
        http.csrf().disable();
        //for cros origin
        http.cors();

        //for spring security session management
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //Login is open for all
        http.authorizeRequests().antMatchers("/login").permitAll();

        //any other request (autre que login) need an authentification
        http.authorizeRequests().anyRequest().authenticated();

    }

    //Filter authenticatian

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        //auth manager Class mere
        return super.authenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}