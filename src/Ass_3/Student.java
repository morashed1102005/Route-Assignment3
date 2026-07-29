package Ass_3;

public class Student {

    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getGradeStatus(){
        if (grade >= 90)
            return "Excellent";
        else if (grade >= 75)
            return "Very Good";
        else if (grade >= 60)
            return "Pass";
        else
            return "Fail";

    }

    public void display() {

        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Grade : " + grade);
        System.out.println("Status : " + getGradeStatus());

    }

}
