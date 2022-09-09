package com.yukkaldiran.fatime.ftteknolojipracticum.dto.converter;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

        public UserDto convertToUserDto(User from){
            return new UserDto(
                    from.getId(),
                    from.getName(),
                    from.getSurname(),
                    from.getEmail(),
                    from.getPhoneNumber()
            );
        }
        public List<UserDto> convertToUserDtoList(List<User> users){
            return users
                    .stream()
                    .map(this::convertToUserDto)
                    .collect(Collectors.toList());
        }
}
