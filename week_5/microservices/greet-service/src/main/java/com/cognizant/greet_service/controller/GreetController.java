package main.java.com.cognizant.greet_service.controller;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello World";
    }
}
