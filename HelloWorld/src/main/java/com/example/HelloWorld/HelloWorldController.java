package com.example.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RestController

//@RequestMapping("/api") // base path if we have mutilple endpoints **
//http://localhost:8081/api/greet?name=John
//http://localhost:8081/api/square/5
//http://localhost:8081/api/hello
//http://localhost:8081/api/hello

public class HelloWorldController {

    //@GetMapping("/hello")  // since we are using @RequestMapping
    //@RequestMapping("/hello") // ye Default chal jayega get agar kuchh specified nhi ho to
    @GetMapping("/api/hello")
    public Map<String, String> sayHello() {
        return Map.of("message", "HelloHello, World!", "status", "success"); // java 9 ka feaature hai, immutable map deta hai thik
    }

    @GetMapping("/api/greet")
    public Map<String, String> greet(String name)
    {
        return Map.of("Greet from", "Hello" + name + "!");
    }


    @GetMapping("/api/format-date")
    public Map<String, String> formatDate(@RequestParam String date) {
        try {
            LocalDate parsedDate = LocalDate.parse(date); // input format: yyyy-MM-dd
            String formatted = parsedDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")); // output: 21 Jun 2025
            return Map.of("formattedDate", formatted);
        } catch (DateTimeParseException e) {
            return Map.of("error", "Invalid date format. Use yyyy-MM-dd");
        }
    }


    @GetMapping("/api/square/{number}")
    public Map<String, Object> square(@PathVariable int number) {
        return Map.of(
                "message", "Square of given " + number + " : " + (number * number),
                "number", number,
                "square", number * number
        );
    }

    @GetMapping("/api/grade")
    public Map<String, Object> grade(@RequestParam int marks) {
        if (marks >= 75 && marks <= 100) {
            return Map.of("marks", marks, "grade", "A");
        } else if (marks >= 60 && marks < 75) {
            return Map.of("marks", marks, "grade", "B");
        } else if (marks >= 40 && marks < 60) {
            return Map.of("marks", marks, "grade", "C");
        } else if (marks >= 0 && marks < 40) {
            return Map.of("marks", marks, "grade", "Fail");
        } else {
            return Map.of("error", "Marks out of valid range (0–100)");
        }
    }


    @GetMapping("/api/user/{id}")
    public Map<String, Object> userinfo(@PathVariable int id, @RequestParam String name)
    {
        return Map.of(
                "userName", name,
                "userId", id
        );
        //return Map.of("UserName", name, "UserId: ", id);
    }




}
