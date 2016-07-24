package client;

/**
 * Created by Aroras on 7/23/2016.
 */
public class Person {

    private String name;
    private int age;
    private long phNum;

    public Person(String name, int age, long phNum) {
        this.name = name;
        this.age = age;
        this.phNum = phNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhNum() {
        return phNum;
    }

    public void setPhNum(long phNum) {
        this.phNum = phNum;
    }

    public String toString(){
        return "name: "+name+" age: "+age+" ph: "+phNum;
    }
}
