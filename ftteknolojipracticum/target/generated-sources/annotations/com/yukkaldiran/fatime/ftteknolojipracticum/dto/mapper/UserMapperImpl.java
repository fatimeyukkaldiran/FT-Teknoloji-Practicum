package com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-09T09:52:25+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(UserSaveRequestDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( userDto.getName() );
        user.setSurname( userDto.getSurname() );
        user.setPhoneNumber( userDto.getPhoneNumber() );

        return user;
    }

    @Override
    public UserDto convertToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setSurname( user.getSurname() );
        userDto.setPhoneNumber( user.getPhoneNumber() );

        return userDto;
    }
}
