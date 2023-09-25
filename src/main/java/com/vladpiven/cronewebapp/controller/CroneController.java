package com.vladpiven.cronewebapp.controller;

import com.vladpiven.cronewebapp.util.CroneHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CroneController {

    @Autowired
    CroneHandler handler;

    @GetMapping("/input")
    public String input(){
        return "input";
    }

    @GetMapping("/parseCrone")
    public String parseCrone(@RequestParam(value = "croneString") String croneString,
                             Model model){

        model.addAttribute("input", croneString);
        model.addAttribute("croneAttributes", handler.getAttributes(croneString));

        String[] croneArr = croneString.split(" ");
        StringBuilder command = new StringBuilder();
        for(int i = 5; i < croneArr.length; i++) command.append(croneArr[i] + " ");
        model.addAttribute("command", command.toString());
        return "print";
    }
}
