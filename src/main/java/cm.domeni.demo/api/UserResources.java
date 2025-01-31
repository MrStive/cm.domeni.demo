package cm.domeni.demo.api;

import cm.domeni.demo.dto.UserDTO;
import cm.domeni.demo.services.UserServices;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserResources implements UserApi {
  private final UserServices userServices;

  @Override
  public ResponseEntity<UUID> createUser(UserDTO userDTO) {
    return ResponseEntity.ok(userServices.createUser(userDTO));
  }
}
