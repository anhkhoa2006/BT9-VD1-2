package vn.iotstar.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.iotstar.dto.UserDTO;
import vn.iotstar.entity.Role;
import vn.iotstar.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-28T10:04:53+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 26.0.2.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setRoleId( entityRoleId( entity ) );
        userDTO.setRoleName( entityRoleName( entity ) );
        userDTO.setId( entity.getId() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setFullName( entity.getFullName() );
        userDTO.setEnabled( entity.isEnabled() );
        userDTO.setCreatedAt( entity.getCreatedAt() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );
        user.setFullName( dto.getFullName() );
        user.setEnabled( dto.isEnabled() );
        user.setCreatedAt( dto.getCreatedAt() );

        return user;
    }

    private Long entityRoleId(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        Long id = role.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String entityRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
