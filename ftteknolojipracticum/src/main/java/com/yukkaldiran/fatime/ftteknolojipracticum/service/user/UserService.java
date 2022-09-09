package com.yukkaldiran.fatime.ftteknolojipracticum.service.user;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.converter.UserConverter;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.mapper.UserMapper;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.product.ProductUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.product.Product;
import com.yukkaldiran.fatime.ftteknolojipracticum.entity.user.User;
import com.yukkaldiran.fatime.ftteknolojipracticum.exception.ProductNotFoundException;
import com.yukkaldiran.fatime.ftteknolojipracticum.exception.UserNotFoundException;
import com.yukkaldiran.fatime.ftteknolojipracticum.repository.user.UserRepository;
import com.yukkaldiran.fatime.ftteknolojipracticum.utils.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserConverter userConverter;

    public UserDto saveUser(UserSaveRequestDto requestDto){
        User user = userMapper.convertToUser(requestDto);
        return userMapper.convertToUserDto(userRepository.save(user));
    }
    public List<UserDto> findUsers(){
        return userConverter.convertToUserDtoList(userRepository.findAll());
    }

    public UserDto getUserById(Long userId){
        return userMapper.convertToUserDto(findUserById(userId));
    }

    public UserDto updateUser(Long userId, UserUpdateRequestDto updateUserRequest){
        User user = findUserById(userId);

        User updatedUser = new User(
                user.getId(),
                updateUserRequest.getName(),
                updateUserRequest.getSurname(),
                updateUserRequest.getEmailAddress(),
                updateUserRequest.getPhoneNumber(),
                user.getProductComments()
        );
        return userMapper.convertToUserDto(userRepository.save(updatedUser));
    }

    public String deleteUser(Long userId){
        userRepository.delete(findUserById(userId));
        return userId + " deleted ...";
    }

    public User findUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(ErrorMessageConstants.USER_NOT_FOUND));
    }
}
