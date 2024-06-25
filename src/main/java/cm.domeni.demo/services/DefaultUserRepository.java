package cm.domeni.demo.services;

import cm.domeni.demo.domain.user.User;
import cm.domeni.demo.domain.user.UserRepository;
import cm.domeni.demo.repository.UserSpringRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultUserRepository implements UserRepository {
  private final UserSpringRepository userSpringRepository;

  @Override
  public User save(User userData) {
    return userSpringRepository.save(userData);
  }
}
