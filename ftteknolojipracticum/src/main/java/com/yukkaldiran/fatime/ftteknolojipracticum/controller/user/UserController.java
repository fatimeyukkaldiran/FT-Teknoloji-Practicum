package com.yukkaldiran.fatime.ftteknolojipracticum.controller.user;

import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserSaveRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.dto.user.UserUpdateRequestDto;
import com.yukkaldiran.fatime.ftteknolojipracticum.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserSaveRequestDto userSaveRequestDto){
        UserDto userDto = userService.saveUser(userSaveRequestDto);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userDtoList = userService.findUsers();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping(path="/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){
       UserDto userDto = userService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserUpdateRequestDto updateUserRequest){
        UserDto userDto = userService.updateUser(updateUserRequest);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping(path="/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId){
        String result = userService.deleteUser(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

