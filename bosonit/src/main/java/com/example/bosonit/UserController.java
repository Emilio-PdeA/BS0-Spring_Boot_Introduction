package com.example.bosonit;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    /*
    * METHOD: GET
    * Test URL: localhost:8080/user/{name}
    * Response: "Hello, {name}"
    */
    private static final String template = "Hello, %s";
    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name){
        return String.format(template,name);
    }

    /*
    * METHOD: POST
    * Test URL: localhost:8080/useradd
    * BODY (JSON): {"name":$name, "city":$city, "age":$age}
    * RESPONSE: {"name":$name, "city":$city, "age":$age + 1}
    * */
    @PostMapping(path="/useradd", consumes = "application/json")
    public ResponseEntity<String> postUser(@RequestBody User user) {
        user.setAge(user.getAge()+1);
        return new ResponseEntity<String>(user.getJSON(), HttpStatus.OK);
    }


}
