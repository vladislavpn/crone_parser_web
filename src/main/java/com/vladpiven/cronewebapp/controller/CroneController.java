package com.vladpiven.cronewebapp.controller;

import com.vladpiven.cronewebapp.service.CroneService;
import com.vladpiven.cronewebapp.util.CroneHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CroneController {

    @Autowired
    CroneService service;

    @GetMapping("/input")
    public String input(){
        return "input";
    }

    @GetMapping("/parseCrone")
    public String parseCrone(@RequestParam(value = "croneString") String croneString,
                             Model model){
        model.addAttribute("input", croneString);
        model.addAttribute("croneAttributes", service.parseCroneExpression(croneString));
        model.addAttribute("command", service.getCommand(croneString));
        return "print";
    }
}
