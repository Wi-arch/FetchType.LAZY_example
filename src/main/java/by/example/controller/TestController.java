package by.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/test/")
public class TestController {

    @GetMapping("get/{name}")
    public String testGetMethod(@PathVariable String name) {
        System.out.println("in TestController, name = " + name);
        return "testGetMethod_" + name;
    }
}
