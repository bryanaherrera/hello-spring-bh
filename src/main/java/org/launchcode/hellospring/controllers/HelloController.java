package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

//@RequestMapping("hello")
public class HelloController {
    //Handles request at path /hello
//    @RequestMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

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
    @RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
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

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Harry");
        names.add("Niall");
        names.add("Zayn");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
