package test.atl.atm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class CustomSecurity extends WebSecurityConfigurerAdapter {

  @Bean
  @Override
  public UserDetailsService userDetailsService() {

    //User Role
    UserDetails theUser = User.withUsername("root")
      .password(passwordEncoder().encode("root")).roles("USER").build();


    InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

    userDetailsManager.createUser(theUser);
    return userDetailsManager;
  }


  public void configure(HttpSecurity http) throws Exception {
    http.httpBasic()
      .and().addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class)
      .authorizeRequests()
      .antMatchers("/api/login**","/","/index.html").permitAll()
      .anyRequest().fullyAuthenticated();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
