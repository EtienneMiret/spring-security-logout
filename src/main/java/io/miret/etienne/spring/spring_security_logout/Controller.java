package io.miret.etienne.spring.spring_security_logout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
public class Controller {

  @GetMapping ("/")
  public Mono<String> authenticated (Principal principal) {
    if (principal == null) {
      return Mono.just ("You are NOT authenticated.");
    } else {
      return Mono.just ("You DO are authenticated.");
    }
  }

}
