package client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jeet.api.ISubTask;
import com.jeet.api.ITask;
import com.jeet.config.Parser;
import com.jeet.controller.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aroras on 7/6/2016.
 */
public class Client {
    public static void main(String[] args) throws Exception {
      //  ITask task = init();
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      // task.stop();
        testJSon();
    }

    private static ITask init(){
        SampleThread1 t1 = new SampleThread1();
        SampleThread1 t2 = new SampleThread1();
        SampleThread1 t3 = new SampleThread1();
        ITask task = new Task();
        task.submit(t1);
        task.submit(t2);
        task.submit(t2);
        task.submit(t3);
        /*task.submit(t1);
        task.submit(t1);
        task.submit(t1);*/
        task.begin();
        return task;
    }

    private static void testJSon() throws Exception{
        FileWriter fr = new FileWriter("Sample.json");
        Person p1 = new Person("Jatin", 35, 988672704);
        Person p2 = new Person("Shweta", 32, 988672705);
        Person p3 = new Person("Arshia", 7, 988672706);

        Data data = new Data();
        data.add(p1);
        data.add(p2);
        data.add(p3);
         data.add(p1);
        data.add(p2);
        data.add(p3);
         data.add(p1);
        data.add(p2);
        data.add(p3);
         data.add(p1);
        data.add(p2);
        data.add(p3);

       /* List<String> p11 = new ArrayList<String>();
        p11.add("Jatin");
        p11.add("35");
        p11.add("988672704");

        List<String> p12 = new ArrayList<String>();
        p12.add("Jatin Arora");
        p12.add("36");
        p12.add("988672705");

        List<String> p13 = new ArrayList<String>();
        p13.add("Jatin Pal");
        p13.add("37");
        p13.add("988672707");*/

     /*   String[] pd1 = new String[3];
        pd1[0] = "JP";
        pd1[1] = "45";
        pd1[2] = "222";

        String[] pd2 = new String[3];
        pd2[0] = "AP";
        pd2[1] = "45";
        pd2[2] = "222";



        Data data = new Data();
        data.add(pd1);
        data.add(pd2);*/

     //   data.add(pd3);
      //  String p1Str = new Gson().toJson(p1, Person.class);
       // String p2Str = new Gson().toJson(p2, Person.class);
        //String p3Str = new Gson().toJson(p3, Person.class);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String d1 = gson.toJson(data, Data.class);
        //String d2 = new Gson().toJson(data, Data.class);


        fr.write(d1);
       /* fr.append('\n');
        fr.write(d2);*/
        //fr.append('\n');
        //fr.write(p2Str);
       // fr.append('\n');
       // fr.write(p3Str);
       // System.out.println(p1Str);
       // System.out.println(p2Str);
       // System.out.println(p3Str);
        fr.flush();

        FileReader frd = new FileReader("Sample.json");



        BufferedReader br = new BufferedReader(frd);
        String line = null;
        StringBuffer sb = new StringBuffer();
       // line = br.readLine();
        while(  (line = br.readLine()) != null){
           sb.append(line);
           // System.out.println("Line: "+line);

        }

        System.out.println(sb.toString());

        Data d = new Gson().fromJson(sb.toString(), Data.class);
        System.out.println("RES: "+d);

      /*  System.out.println(new Gson().fromJson(p1Str, Person.class));
        System.out.println(new Gson().fromJson(p2Str, Person.class));
        System.out.println(new Gson().fromJson(p3Str, Person.class));
*/
    }
}
