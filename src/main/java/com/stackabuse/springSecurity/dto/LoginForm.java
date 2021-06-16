package com.stackabuse.springSecurity.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    @NotBlank
    @Size(min=3, max = 60)
    private String email;
 
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    
    @Valid
    @NotNull(message = "Device info cannot be null")
    private DeviceInfo deviceInfo;
}
