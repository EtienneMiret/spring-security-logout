package io.miret.etienne.spring.spring_security_logout;

import org.springframework.security.web.server.context.WebSessionServerSecurityContextRepository;

public class CustomSecurityContextRepository extends WebSessionServerSecurityContextRepository {

  public CustomSecurityContextRepository () {
    setSpringSecurityContextAttrName ("Some custom name.");
  }

}
