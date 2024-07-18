package com.essam.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO  implements Serializable {

    @JsonProperty(value = "id")
    private Integer id;
    @Email
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "mobile_number")
    private String mobileNumber;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "middle_name")
    private String middleName;
    @JsonProperty(value = "last_name")
    private String lastName;

}
