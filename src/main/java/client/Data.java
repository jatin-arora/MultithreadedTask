package client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aroras on 7/24/2016.
 */
public class Data {

    private List<Person> persons;

    public Data(){
        persons = new ArrayList<Person>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;

    }

    public void add(Person person){
        this.persons.add(person);
        System.out.println(persons.size()+person.toString()+"");
    }

    @Override
    public String toString() {
        String str="";
        for (Person s : persons){
                str += s+", ";

        }
        return str;
    }
}
