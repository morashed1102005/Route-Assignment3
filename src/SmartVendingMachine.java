import java.util.Scanner;

public class SmartVendingMachine {
    public static void main(String[] args) {
        double totalBill = 0;
        int choice;
        int quantity;
        double price = 0;
        Scanner sc =new Scanner(System.in);
        while (true){
            System.out.println("========Smart Vending Machine===========");
            System.out.println("1.Coffee - 50");
            System.out.println("2.Tee - 35");
            System.out.println("3.Hot Chocolate - 60");
            System.out.println("4.Water - 20");
            System.out.println("5.Exist");
            System.out.println("Choose : ");
            choice = sc.nextInt();
            if (choice==5)
                break;
            switch (choice){
                case 1 :
                    price = 50;
                    break;
                case 2 :
                    price = 35;
                    break;
                case 3 :
                    price = 60;
                    break;
                case 4 :
                    price = 20;
                    break;
                default:
                    System.out.println("Invalid number");
                    continue;

            }
            System.out.println("Enter quantity");
            quantity = sc.nextInt();
            if (quantity <= 0){
                System.out.println("Invalid quantity");
                continue;
            }
            double orderTotal = price*quantity;
            totalBill += orderTotal;
            System.out.println("Order total : " + orderTotal);
            System.out.println("Current bill : "+ totalBill);

        }
        double amountPaid;
        System.out.println("Enter amount to paid");
        amountPaid = sc.nextInt();
        while (amountPaid < totalBill){
            System.out.println("Error");
            System.out.println("Enter amount to paid again");
            amountPaid =sc.nextInt();

        }
        double discount = 0;
        if (totalBill >= 300){
            discount = totalBill*0.15;
        } else if (totalBill >= 150 ) {
            discount = totalBill * 0.10;

        }
        double finalPrice = totalBill - discount;
        double change = amountPaid - finalPrice;


        System.out.println("\n===== Receipt =====");
        System.out.println("Total Bill : " + totalBill);
        System.out.println("Discount   : " + discount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("Amount Paid: " + finalPrice);
        System.out.println("Change     : " + change);


    }


}

