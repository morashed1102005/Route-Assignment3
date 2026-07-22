    import java.util.Scanner;

    public class Ass_2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            char[][] seats = new char[5][6];
            String[] movieNames = {
                    "Superman",
                    "Avatar",
                    "Minecraft",
                    "Inside Out",
                    "F1"
            };
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    seats[i][j] = 'O';
                }
            }
            while (true) {
                System.out.println("==========Main Menu============");
                System.out.println("1. Display Seats");
                System.out.println("2. Book Seat");
                System.out.println("3. Cancel Booking");
                System.out.println("4. Show all movies");
                System.out.println("5. Show number of available and booked seats");
                System.out.println("0. Exit");
                int choice = sc.nextInt();
                if (choice == 0) {
                    System.out.println("Thank you for using Cinema Booking System.");
                    break;
                }
                switch (choice) {
                    case 1:
                        for (int i = 0; i < seats.length; i++) {

                            for (int j = 0; j < seats[i].length; j++) {

                                System.out.print(seats[i][j] + " ");

                            }

                            System.out.println();

                        }

                        break;

                    case 2:
                        System.out.println("Enter row (1-5): ");
                        int row = sc.nextInt();
                        System.out.println("Enter seat (1-6): ");
                        int seat = sc.nextInt();
                        if (row < 1 || row > 5 || seat < 1 || seat > 6) {
                            System.out.println("Invalid Seat.");
                        } else {
                            if (seats[row - 1][seat - 1] == 'O') {
                                seats[row - 1][seat - 1] = 'X';
                                System.out.println("Seat booked successfully.");
                            } else {
                                System.out.println("Seat is already booked.");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Enter row (1-5): ");
                        row = sc.nextInt();
                        System.out.println("Enter seat (1-6): ");
                        seat = sc.nextInt();
                        if (row < 1 || row > 5 || seat < 1 || seat > 6) {
                            System.out.println("Invalid Seat.");
                        } else {
                            if (seats[row - 1][seat - 1] == 'X') {
                                seats[row - 1][seat - 1] = 'O';
                                System.out.println("Booking cancelled");
                            } else
                                System.out.println("The seat is available");
                        }
                        break;

                    case 4:
                        for (int i = 0; i < movieNames.length; i++) {
                            System.out.println(movieNames[i]);
                        }
                        break;

                    case 5:
                        int available = 0;
                        int booked = 0;
                        for (int i = 0; i < seats.length; i++) {
                            for (int j = 0; j < seats[i].length; j++) {
                                if (seats[i][j] == 'O') {
                                    available++;
                                } else
                                    booked++;

                            }
                        }
                        System.out.println("Available Seats: " + available);
                        System.out.println("Booked Seats: " + booked);
                        break;
                    default:
                        System.out.println("Invalid Choice.");
                }
            }
        }
    }
