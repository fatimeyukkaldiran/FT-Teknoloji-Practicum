package com.yukkaldiran.fatime.ftteknolojipracticum.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserSaveRequestDto {

    @NotEmpty
    @NotNull
    @Size(max=50)
    private String name;

    @NotEmpty
    @NotNull
    @Size(max=50)
    private String surname;

    @Email
    @Size(max=50)
    private String emailAddress;

    @NotEmpty
    @NotNull
    @Size(max=50)
    private String phoneNumber;

}
