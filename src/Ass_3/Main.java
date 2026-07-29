package Ass_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int N = sc.nextInt();

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++){
            System.out.println("Enter data for student " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            double grade;

            do {
                System.out.print("Enter Grade: ");
                grade = sc.nextDouble();

                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid Grade! Enter between 0 and 100.");
                }

            } while (grade < 0 || grade > 100);


            students[i] = new Student(id,name,grade);
            System.out.println("-------------------");

        }
        while (true){

            System.out.println("===========================");
            System.out.println("1. Display Students");
            System.out.println("2. Calculate Average Grade");
            System.out.println("3. Find Highest Grade");
            System.out.println("4. Search Student by ID");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice==0){
                System.out.println("Program Ended.");
                break;
            }

            switch (choice){

                case 1:
                    displayStudents(students);
                    break;

                case 2:
                    calculateAverage(students);
                    break;

                case 3:
                    findHighestGrade(students);
                    break;

                case 4:
                    searchStudentById(students,sc);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        }

    }
    public static void displayStudents (Student[] students){
        for (int i = 0; i<students.length;i++){
            students[i].display();
        }
    }
    public static void calculateAverage(Student[] students){
        double sum = 0;
        for (int i = 0; i<students.length; i++){

            sum+=students[i].getGrade();
        }
        double average = sum/students.length;
        System.out.println("Average Grade = " + average );
    }
    public static void findHighestGrade(Student[] students){
        Student highestStudent = students[0];

        for (int i = 1; i<students.length; i++){
            if (students[i].getGrade()> highestStudent.getGrade()) {
                highestStudent=students[i];
            }
        }
        System.out.println("Student with Highest Grade:");
        highestStudent.display();
    }
    public static void searchStudentById(Student[] students, Scanner sc){
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        boolean found = false;
        for (int i = 0; i<students.length; i++){
            if (students[i].getId()==id){
                students[i].display();
                found=true;
                break;
            }
        }
        if (!found){
            System.out.println("Student not found");
        }
    }
}
