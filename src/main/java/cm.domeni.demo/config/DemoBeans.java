package cm.domeni.demo.config;

import cm.domeni.demo.domain.user.UserRepository;
import cm.domeni.demo.repository.UserSpringRepository;
import cm.domeni.demo.services.DefaultUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DemoBeans {

  @Bean
  public UserRepository userRepository(UserSpringRepository userSpringRepository) {
    return new DefaultUserRepository(userSpringRepository);
  }
}
