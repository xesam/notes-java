package dev.xesam.javalang.lang;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xe on 14-10-24.
 */
public class Feature {
    public static void main(String[] args) {
        Feature main = new Feature();
//        main.dateTime();
//        main.stream();
        main.numberFormat();
    }

    static interface DefaultInterface {
        default int getInt() {
            return 1;
        }
    }

    public void dateTime() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate yearStart = LocalDate.parse("01/01/2014", formatter);
        System.out.println(yearStart);

    }

    public void stream() {
        List<String> myList = new ArrayList();
        for (int x = 0; x <= 10; x++) {
            myList.add("Test " + x);
        }
        myList.stream().forEach((value) -> {
            System.out.println(value);
        });

    }

    public void loadInlineJs() {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine nashorn = sem.getEngineByName("nashorn");
        try {
            nashorn.eval("print('This is being printed with JavaScript');");
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
    }

    public void numberFormat() {
        NumberFormat numberFormatter = new DecimalFormat("##.000");
        String result = numberFormatter.format(345.9372);
        System.out.println(result);
    }


}