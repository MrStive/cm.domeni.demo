package cm.domeni.demo.services;

import cm.domeni.demo.domain.user.User;
import cm.domeni.demo.dto.UserDTO;
import cm.domeni.demo.repository.UserSpringRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServices {
    private final UserSpringRepository userSpringRepository;
    private final UserMapper userMapper;
    public UserServices(UserSpringRepository userSpringRepository, UserMapper userMapper) {
        this.userSpringRepository = userSpringRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UUID createUser(UserDTO userDTO) {
        return User.create(userMapper.mapToUser(userDTO), new DefaultUserRepository(userSpringRepository)).toUuid();
    }
}
