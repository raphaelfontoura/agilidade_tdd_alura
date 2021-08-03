package br.com.caelum.clines.api.users;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UserForm {
    @NotBlank
    private String name;
    @NotBlank @Email
    private String email;
    @NotNull
    private String password;

    public UserForm(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
