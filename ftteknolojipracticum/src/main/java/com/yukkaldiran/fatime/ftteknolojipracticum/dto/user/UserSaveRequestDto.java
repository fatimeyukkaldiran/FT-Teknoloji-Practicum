package com.yukkaldiran.fatime.ftteknolojipracticum.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserSaveRequestDto {

    @NotNull
    @Size(max=50)
    private String name;

    @NotNull
    @Size(max=50)
    private String surname;

    @Email
    @Size(max=50)
    private String email;

    @NotNull
    @Size(max=50)
    private String phoneNumber;

}
