package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FirstControllers {

    // ================== COMMON REQUEST MAPPINGS

    // @GetMapping
    // @PostMapping
    // @DeleteMapping
    // @PutMapping
    // @PatchMapping

    // ================== EXAMPLE ENDPOINTS

//    @GetMapping("/")
//    @ResponseBody
//    public String returnHomePage() {
//        return "Welcome!";
//    }

//    @GetMapping("/hello")
//    @ResponseBody
//    public String returnHelloWorld() {
//        return "Hello Dragon!";
//    }

    @GetMapping("/another")
    @ResponseBody
    public String returnAnother() {
        return "Hello Codeup!";
    }

    // ================== VARIOUS CONTENT TYPES FOR THE RESPONSE

    // text response
//    @GetMapping(path = "/text", produces = "text/text")
//    @ResponseBody
//    public String showText() {
//        return "Here is some plain text";
//    }

    // html response
//    @GetMapping(path = "/html", produces = "text/html")
//    @ResponseBody
//    public String showHTML() {
//        return "<h1>Howdy, Dragon!</h1>";
//    }

    // record to create simple POJOs in memory
//    public record Person (String name, String address) {}

    // json response
//    @GetMapping(path = "/json", produces = "application/json")
//    @ResponseBody
//    public List<Person> showPeople() {
//        List<Person> people = new ArrayList<>(Arrays.asList(
//            new Person("David", "123 Place Lane"),
//            new Person("Justin", "321 Somewhere Pkwy")
//        ));
//        return people;
//    }

    // submit forms back to the server...
//    @GetMapping(path = "/cohorts", produces = "text/html")
//    @ResponseBody
//    public String showCohorts() {
//        return "<h1>Cohort Form</h1><form action='/cohorts' method='POST'><input type='hidden' value='dragon' name='cohort'><button>Submit</button></form>";
//    }
//
//    @PostMapping("/cohorts")
//    public String processRequest(@RequestParam String cohort) {
//        System.out.println("The cohort is: " + cohort);
//        return "redirect:/cohorts";
//    }

//    @PostMapping("/register")
//    public void register(
//        @RequestParam String username,
//        @RequestParam String email,
//        @RequestParam String password) {
//        // sign the user up for the application
//    }


    // ================== PATH VARIABLES

    // localhost:8080/greeting/hello
    // localhost:8080/greeting/howdy
    // localhost:8080/greeting/goodday
    @GetMapping("/greeting/{greeting}")
    @ResponseBody
    public String returnGreeting(@PathVariable String greeting) {
        return "The greeting is " + greeting;
    }

    @GetMapping("/namegreeting/{firstName}/{lastName}")
    @ResponseBody
    public String returnNameGreeting(@PathVariable String firstName, @PathVariable String lastName) {
        return "Hello, " + firstName + " " + lastName;
    }

}
