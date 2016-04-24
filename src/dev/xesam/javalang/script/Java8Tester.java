package dev.xesam.javalang.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by xe xesamguo@gmail.com on 12/10/15.
 */
public class Java8Tester {
    public void test_1(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Mahesh";

        Integer result = null;
        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        }catch(ScriptException e){
            System.out.println("Error executing script: "+ e.getMessage());
        }
        System.out.println(result.toString());
    }
}
