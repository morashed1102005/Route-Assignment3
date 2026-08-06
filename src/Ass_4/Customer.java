package Ass_4;

public class Customer {

    private static int nextCustomerID = 1;
    private int customerID;
    private String fullName;
    private String nationalID;
    private String phoneNumber;
    private CustomerTier customerTier;
    private int openAccountCount;

    public Customer(String fullName, String nationalID,
                    String phoneNumber, CustomerTier customerTier) {

        this.customerID = nextCustomerID++;
        this.fullName = fullName;
        this.nationalID = nationalID;
        this.phoneNumber = phoneNumber;
        this.customerTier = customerTier;
        this.openAccountCount = 0;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerTier getCustomerTier() {
        return customerTier;
    }
    public int getOpenAccountCount() {
        return openAccountCount;
    }


    public void increaseOpenAccountCount() {
        openAccountCount++;
    }
    public void decreaseOpenAccountCount(){
        if (openAccountCount > 0){
            openAccountCount--;
        }
    }


    public void displayCustomerInfo() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Full Name: " + fullName);
        System.out.println("National ID: " + nationalID);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Customer Tier: " + customerTier);
    }
}
