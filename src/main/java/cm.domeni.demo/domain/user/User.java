package cm.domeni.demo.domain.user;

import cm.domeni.demo.domain.DemoEntityBase;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
@FieldNameConstants
@Table(name = "t_user")
public class User extends DemoEntityBase<UserId> {
    @EmbeddedId
    @AttributeOverride(name = "value", column = @Column(name = "c_id", updatable = false))
    @Builder.Default
    private UserId id = new UserId();
    @Column(name = "c_user_name")
    private String username;
    @Column(name = "c_first_name")
    private String firstName;
    @Column(name = "c_last_name")
    private String lastName;

    public static UserId create(User userData, UserRepository userRepository) {
        return userRepository.save(userData).id;
    }
}
