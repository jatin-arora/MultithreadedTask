package logs;

/**
 * Created by Aroras on 7/6/2016.
 */
public class Logger {

    public static void log( String string){
        log(null, string);
    }
    public static void log(Object obj, String string){
        String className = obj == null ? "*" : obj.getClass().getSimpleName();
        System.out.println(className +" :-> "+string);
    }
}
