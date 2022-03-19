package com.nisum.api.nisum.web;

import javax.validation.Valid;
import com.nisum.api.nisum.exception.BusinessException;
import com.nisum.api.nisum.service.IUserService;
import com.nisum.api.nisum.web.request.UserRequest;
import com.nisum.api.nisum.web.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "Microservicio Nisum",
        description = "Permite registrar un usuario", version = "1.0.0",
        contact = @Contact(name = "Erick Diaz", email = "erickdiazc@outlook.es")))
public class NisumController {

    @Autowired
    private IUserService service;

    @PostMapping("/register")
    @Operation(method = "POST", summary = "Registra un usuario")
    public UserResponse registerUser(@RequestBody @Valid UserRequest request)
            throws BusinessException {
        return service.registerUser(request);
    }

}
