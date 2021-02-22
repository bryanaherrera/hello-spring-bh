package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

//@RequestMapping("hello")
public class HelloController {
    //Handles request at path /hello
    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring";
    }

    @RequestMapping(value="/error", method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String error(){
        return "This is an Error page";
    }

    //lives /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring";
    }

    //lives /hello/hello
    //Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    // /hello/hello
//    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @GetMapping("hello/greeting")
    @ResponseBody
    public String createMessage (@RequestParam String name, @RequestParam String language){
        if(language.equals("Spanish")){
            return "Hola " + name + "!";
        }
        else if(language.equals("French")){
            return "Bonjour " + name + ".";
        }
        return "Hello, " + name + "!";
    }
}
