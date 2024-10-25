package edu.fra.uas.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class helloWorldController {
        
        @RequestMapping(value = "hello", method = RequestMethod.GET)
        @ResponseBody
        public String helloWorld() {
            return "<h1>Hello World!</h1>";
        }

}