package com.vladpiven.cronewebapp.util;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CronHandler { /* Responsible for parsing a crone string into separate attributes such as minutes, hours etc.*/

    static HashMap<String, String> attributes;


    private enum Attributes{
        MINUTES("minutes"),
        HOURS("hours"),
        DAY_OF_MONTH("day of month"),
        MONTH("month"),
        DAY_OF_WEEK("day of week");
        private final String name;
        private Attributes(String name){
            this.name = name;
        }
    }

    public HashMap<String, String> getAttributes(String cron){
        attributes = new HashMap<>();
        String[] cronArr = cron.split(" ");

        fillAttributes(Attributes.MINUTES, cronArr[0], 60, 0);
        fillAttributes(Attributes.HOURS, cronArr[1], 24, 0);
        fillAttributes(Attributes.DAY_OF_MONTH, cronArr[2], 32, 1);
        fillAttributes(Attributes.MONTH, cronArr[3], 13, 1);
        fillAttributes(Attributes.DAY_OF_WEEK, cronArr[4], 7, 0);

        return attributes;
    }

    private void fillAttributes(Attributes attribute, String toParse, int ceil, int ground){
        StringBuilder parsed = new StringBuilder();
        if(attribute != Attributes.DAY_OF_WEEK) for(var i : parseCron(toParse, ceil, ground)) parsed.append(i + " ");
        else for(var i : parseCron(toParse, ceil, ground)) parsed.append(parseDays(i) + " ");
        attributes.put(attribute.name, parsed.toString());
    }

    static String parseDays(Integer day){
        if(day == 0) return "sun";
        if(day == 1) return "mon";
        if(day == 2) return "tue";
        if(day == 3) return "wed";
        if(day == 4) return "thu";
        if(day == 5) return "fri";
        if(day == 6) return "sat";
        return null;
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
        else{
            if(Integer.parseInt(val) >= ceil) return values;
            values.add(Integer.parseInt(val));
        }
        return values;
    }
}
