package org.infy.UserServiceApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.kafka.common.protocol.types.Field;
import org.infy.UserServiceApplication.model.UserIdentifier;
import org.infy.UserServiceApplication.model.UserType;
import org.infy.UserServiceApplication.model.Users;

import static org.infy.UserServiceApplication.model.Users.*;

@Getter
@Setter
//@
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRequestDTO {

    private String name;

    @NotBlank(message = "Contact can't be blank")
    private String contact;


    @NotBlank(message = "Email can't be blank")
    private String email;
    private String address;
    private String dob;
    @NotNull(message = "UserIdentifier can't be blank")
    private UserIdentifier userIdentifier;
    @NotBlank(message = "userIdentifierValue can't be blank")
    private String userIdentifierValue;

    @NotBlank(message = "password can't be blank")
    private String password;



    public Users toUser() {
        return Users.builder()
                .name(this.name)
                .contact(this.contact)
                .email(this.email)
                .address(this.address)
                .dob(this.dob)
                .identifier(this.userIdentifier)
                .userIdentifierValue(this.userIdentifierValue)
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .userType(UserType.USER)
                .build();
    }
}
