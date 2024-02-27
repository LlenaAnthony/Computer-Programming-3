package module2.sample2;

import java.io.Serializable;

public class Student implements Serializable {
    private int id, year;
    private String name, course, gender;


    public Student (int i, String n, String c, int y, String g){
        id = i;
        name = n;
        course = c;
        year = y;
        gender = g;
    }

    public int getID(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse(){
        return course;
    }

    public int getYear(){
        return year;
    }

    public String getGender(){
        return gender;
    }





}
