package org.myshelf.java19modules;

import org.myshelf.java19modules.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String greeting(@RequestParam String name) {
        return new Greeting(name).toString();
    }
}
