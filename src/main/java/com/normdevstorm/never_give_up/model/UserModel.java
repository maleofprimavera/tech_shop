package com.normdevstorm.never_give_up.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

///using @Data annotation to reduce boilerplate code (getters and setters, hashCode and equals func)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
}
