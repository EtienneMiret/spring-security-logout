package io.miret.etienne.spring.spring_security_logout;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.adapter.AbstractReactiveWebInitializer;

@Configuration
@EnableWebFluxSecurity
@EnableWebFlux
@ComponentScan ("io.miret.etienne.spring.spring_security_logout")
public class Main extends AbstractReactiveWebInitializer {

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain (ServerHttpSecurity http) {
    return http
        .securityContextRepository (securityContextRepository ())
        .formLogin ()
            .and ()
        .logout ()
            .logoutUrl ("/logout")
            .and ()
        .build ();
  }

  @Bean
  public ServerSecurityContextRepository securityContextRepository () {
    return new CustomSecurityContextRepository ();
  }

  @Bean
  public ReactiveUserDetailsService userDetailsService () {
    var user = User.withDefaultPasswordEncoder ()
        .username ("user")
        .password ("user")
        .roles ("USER")
        .build ();
    return new MapReactiveUserDetailsService (user);
  }

  @Override
  protected Class<?>[] getConfigClasses () {
    return new Class<?>[] { Main.class };
  }

}
