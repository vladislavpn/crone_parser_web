package com.vladpiven.cronewebapp.service;

import com.vladpiven.cronewebapp.util.CroneHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CroneService {

    @Autowired
    CroneHandler handler;

    public HashMap<String, String> parseCroneExpression(String crone) {
        return handler.getAttributes(crone);
    }

    public String getCommand(String crone){
        String[] croneArr = crone.split(" ");
        StringBuilder command = new StringBuilder();
        for(int i = 5; i < croneArr.length; i++) command.append(croneArr[i] + " ");
        return command.toString();
    }
}
