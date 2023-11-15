package com.springbootworkshop.openai.Controller;

import com.springbootworkshop.openai.Service.WelcomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    private final WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping("/hello/{name}")
    public String sayHi(@PathVariable String name){
        return welcomeService.sayHi(name);
    }

    @PostMapping("/hello")
    public String sayHiPost(@RequestBody String name){
        return welcomeService.sayHi(name);
    }

}
