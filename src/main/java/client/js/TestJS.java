package client.js;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * Created by Aroras on 7/6/2016.
 */
public class TestJS {

    public class Test {
         public String getName(){
             return "JATIN";
         }
    }

    public void runJS(){
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine eng = mgr.getEngineByName("JavaScript");
            FileReader fr = new FileReader("Sample.js");
            eng.put("Name", new Test());
            Object o = eng.eval(fr);
            System.out.println("RES:)"+o);
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
