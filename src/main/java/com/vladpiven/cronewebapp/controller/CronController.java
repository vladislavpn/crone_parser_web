package com.vladpiven.cronewebapp.controller;

import com.vladpiven.cronewebapp.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CronController {

    @Autowired
    CronService service;

    @GetMapping("/input")
    public String input(){
        return "input";
    }

    @GetMapping("/parseCron")
    public String parseCron(@RequestParam(value = "cronString") String croneString,
                             Model model){
        model.addAttribute("input", croneString);
        model.addAttribute("croneAttributes", service.parseCroneExpression(croneString));
        model.addAttribute("command", service.getCommand(croneString));
        return "print";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("error", ex);
        return "input";
    }
}
