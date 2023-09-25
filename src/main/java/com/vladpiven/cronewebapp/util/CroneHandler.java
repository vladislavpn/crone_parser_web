package com.vladpiven.cronewebapp.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CroneHandler {
    public HashMap<String, String> getAttributes(String crone){
        HashMap<String, String> attributes = new HashMap<>();
        String[] croneArr = crone.split(" ");

        StringBuilder minutes = new StringBuilder();
        for(var i : parseCron(croneArr[0], 60, 0)) minutes.append(i + " ");
        attributes.put("minutes", minutes.toString());

        StringBuilder hours = new StringBuilder();
        for(var i : parseCron(croneArr[1], 24, 0)) hours.append(i + " ");
        attributes.put("hours", hours.toString());

        StringBuilder dayOfMonth = new StringBuilder();
        for(var i : parseCron(croneArr[2], 32, 1)) dayOfMonth.append(i + " ");
        attributes.put("day of month", dayOfMonth.toString());

        StringBuilder months = new StringBuilder();
        for(var j : parseCron(croneArr[3], 13, 1)) months.append(j + " ");
        attributes.put("month", months.toString());

        StringBuilder daysOfWeek = new StringBuilder();
        for(var i : parseCron(croneArr[4], 7, 0)) daysOfWeek.append(i + " ");
        attributes.put("day of week", daysOfWeek.toString());

        return attributes;
    }

    private static Set<Integer> parseCron(String exp, int ceil, int ground){
        SortedSet<Integer> result = new TreeSet<>();
        for(String val : exp.split(",")){
            int stepIndx = val.indexOf('/');
            if(stepIndx != -1){
                int step = Integer.parseInt(val.substring(stepIndx+1));
                result.addAll(getCronWithStep(val.substring(0, stepIndx), step, ceil));
            }
            else{
                result.addAll(getCronNoStep(val, ceil));
            }
        }
        return result.tailSet(ground);
    }


    private static List<Integer> getCronWithStep(String val, int step, int ceil){
        List<Integer> values = new ArrayList<>();
        int range = val.indexOf('-');
        if(range != -1){
            int from = Integer.parseInt(val.substring(0, range));
            int to = Integer.parseInt(val.substring(range + 1));
            for(int i = from; i <= to; i += step){
                values.add(i);
            }
        }
        else{
            int from;
            if(val.equals("*")) from = 0;
            else from = Integer.parseInt(val);
            for(int i = from; i < ceil; i += step){
                values.add(i);
            }
        }
        return values;
    }

    private static List<Integer> getCronNoStep(String val, int ceil){
        List<Integer> values = new ArrayList<>();
        if(val.equals("*")){
            for(int i = 0; i < ceil; i++) values.add(i);
            return values;
        }
        int range = val.indexOf('-');
        if(range != -1){
            int from = Integer.parseInt(val.substring(0, range));
            int to = Integer.parseInt(val.substring(range + 1));
            for(int i = from; i <= to; i++){
                values.add(i);
            }
        }
        else values.add(Integer.parseInt(val));
        return values;
    }
}
