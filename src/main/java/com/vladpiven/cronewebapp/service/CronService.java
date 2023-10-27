package com.vladpiven.cronewebapp.service;

import com.vladpiven.cronewebapp.util.CronHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CronService {

    @Autowired
    CronHandler handler;

    public HashMap<String, String> parseCroneExpression(String cron) {
        return handler.getAttributes(cron);
    }

    public String getCommand(String cron){
        String[] croneArr = cron.split(" ");
        StringBuilder command = new StringBuilder();
        for(int i = 5; i < croneArr.length; i++) command.append(croneArr[i] + " ");
        return command.toString();
    }
}
