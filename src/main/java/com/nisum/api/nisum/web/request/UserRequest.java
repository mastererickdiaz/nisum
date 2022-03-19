package com.nisum.api.nisum.web.request;

import static com.nisum.api.nisum.util.Constants.PASSWORD;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    @NotBlank
    @Size(max = 150)
    public String name;

    @NotBlank
    @Size(max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    public String email;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = PASSWORD)
    public String password;

    @Valid
    @JsonProperty("phones")
    public List<Phone> phones;

}
