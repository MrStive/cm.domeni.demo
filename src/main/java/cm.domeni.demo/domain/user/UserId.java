package cm.domeni.demo.domain.user;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class UserId implements Serializable {
  private String value;

  public UserId(String value) {
    this.value = value;
  }

  public UserId() {
    this.value = UUID.randomUUID().toString();
  }

  public UUID toUuid() {
    return UUID.fromString(value);
  }
}
