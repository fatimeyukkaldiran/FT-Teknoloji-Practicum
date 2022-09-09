package com.yukkaldiran.fatime.ftteknolojipracticum.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDto {

    private Long id;

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
