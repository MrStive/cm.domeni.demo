package cm.domeni.demo.services;

import cm.domeni.demo.domain.user.User;
import cm.domeni.demo.dto.UserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
  @BeanMapping(ignoreByDefault = true)
  @Mapping(target = "firstName", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "username", source = "userName")
  User mapToUser(UserDTO value);
}
