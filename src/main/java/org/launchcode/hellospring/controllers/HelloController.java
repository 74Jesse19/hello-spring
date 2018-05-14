package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //tells that this class below is a controller class
public class HelloController {
    @RequestMapping(value = "") //value="" sets it to root
    @ResponseBody //this is for when you wantto return plain text and not a template
    public String index(HttpServletRequest request){

        String name = request.getParameter("name"); // the key in the parenthesis has to match the query string in the url
        if (name == null){
            name = "World"; //this if statement safeguards against returning null values
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method= RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type = text name = 'name'/>" +
                "<input type= 'submit' value='Greet Me!'>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method= RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    public String goodbye(){
        return "redirect:/"; //redirects to root
    }
}
