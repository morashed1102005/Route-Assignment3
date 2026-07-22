import java.util.Scanner;

public class Ass_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[]names=new String[5];
        int[][]grades=new int[5][3];
        for (int i =0; i<names.length;i++){
            System.out.println("Enter student "+(i+1)+" name:");
            names[i]=sc.nextLine();

        }
        for (int i = 0; i < grades.length; i++) {

            System.out.println("Enter grades for " + names[i]);

            for (int j = 0; j < grades[i].length; j++) {

                while (true) {

                    System.out.print("Subject " + (j + 1) + ": ");
                    grades[i][j] = sc.nextInt();

                    if (grades[i][j] >= 0 && grades[i][j] <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid grade.");
                    }

                }

            }

        }
        while (true){
            System.out.println("========Main Menu========");
            System.out.println("1. Show All Students names.");
            System.out.println("2. Show all Students grades in each subject.");
            System.out.println("3. Search Student by name.");
            System.out.println("4. Count Passed Students");
            System.out.println("0. Exit");
            int choice =sc.nextInt();
            if (choice==0) {
                break;
            }
            switch (choice){
                case 1:
                    for (int i =0;i< names.length;i++){
                        System.out.println(names[i]);
                    }
                    break;
                case 2 :
                    for (int i=0;i<grades.length;i++){
                        System.out.println(names[i]);
                        for (int j=0;j<grades[i].length;j++){
                            System.out.println("Subject " + (j + 1) + ": " + grades[i][j]);

                        }
                        System.out.println();
                    }
                    break;
                case 3 :
                    sc.nextLine();
                    System.out.println("Enter the name");
                    String search = sc.nextLine();
                    boolean found = false;
                    for (int i=0; i<names.length;i++){
                        if (names[i].equals(search)){
                            System.out.println(names[i]);
                            found=true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("not found");
                case 4 :
                    int passedStudents=0;
                    for (int i=0; i<grades.length;i++){
                        boolean passed =true;
                        for (int j=0; j<grades[i].length;j++){
                            if (grades[i][j]<50) {
                                passed = false;
                                break;
                            }

                        }if (passed)
                            passedStudents++;
                    }
                    System.out.println("Passed Students = "+passedStudents);
                    break;
                default:
                    System.out.println("invalid choice");

            }
        }


    }
}
