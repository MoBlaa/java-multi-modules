package org.myshelf.java19modules;

import lombok.AllArgsConstructor;
import org.myshelf.java19modules.domain.Greeting;
import org.myshelf.java19modules.domain.UserInputBoundary;
import org.myshelf.java19modules.domain.UserRequestDto;
import org.myshelf.java19modules.domain.UserResponseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class Controller {
    final UserInputBoundary userInput;

    @GetMapping("/")
    public String greeting(@RequestParam String name) {
        return new Greeting(name).toString();
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto create(@RequestBody UserRequestDto requestModel) {
        return userInput.create(requestModel);
    }
}
