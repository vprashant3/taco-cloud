package com.Foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/echo")
public class FooController {

    @Autowired
    FooService fooService;

    @GetMapping()
    public String echo(){
        return "echo";
    }

    @GetMapping("/all")
    public List<String> getAll() {
        return fooService.getAll();
    }

}
