package org.myshelf.java19modules.controllers;

import lombok.AllArgsConstructor;
import org.myshelf.java19modules.usecases.register.UserRegisterInputBoundary;
import org.myshelf.java19modules.usecases.register.UserRegisterRequestDto;
import org.myshelf.java19modules.usecases.register.UserRegisterResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class Controller {
    final UserRegisterInputBoundary userInput;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRegisterResponseDto register(@RequestBody UserRegisterRequestDto requestModel) {
        return userInput.register(requestModel);
    }
}
