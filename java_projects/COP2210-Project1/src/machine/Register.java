package machine;

import food.Apple;
import food.Sandwich;
import transactions.Payment;

public class Register {

    //----------------------------------------------------------
    // Class variables
    //----------------------------------------------------------
    private static int registerCounter = 0;
    private static final  String REGISTERCODE =  "US-FL-032020-";

    private static final double DOLLARVALUE = 1.00;
    private static final double QUATERVALUE = 0.25;
    private static final double DIMEVALUE = 0.10;
    private static final double NICKELVALUE = 0.05;
    private static final double PENNYVALUE = 0.01;


    //----------------------------------------------------------
    // Instant variables
    // ---------------------------------------------------------
    private String registerID;
    private int numberOfOneDollarBills;
    private int numberOfQuarters;
    private int numberOfDimes;
    private int numberOfNickels;
    private int numberOfPennies;
    private  double currentTotal;

    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------

    public void setRegisterID(String registerID){
        this.registerID = REGISTERCODE+registerCounter;
    }


    public Register(int numberOfOneDollarBills,
                    int numberOfQuarters,
                    int numberOfDimes,
                    int numberOfNickels,
                    int numberOfPennies) {
       registerCounter++;

        currentTotal = 0.0;

        this.numberOfOneDollarBills = numberOfOneDollarBills;
        this.numberOfQuarters = numberOfQuarters;
        this.numberOfDimes = numberOfDimes;
        this.numberOfNickels = numberOfNickels;
        this.numberOfPennies = numberOfPennies;
    }

    private double cashValue(){

        double total =  (numberOfOneDollarBills * DOLLARVALUE) +
                        (numberOfQuarters * QUATERVALUE) +
                        (numberOfDimes * DIMEVALUE) +
                        (numberOfNickels * NICKELVALUE) +
                        (numberOfPennies * PENNYVALUE);

        return total;
    }

    public void cashInfo(String personal){

        if(personal == "Manager") {
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Valid");
            System.out.printf("Cash in the Register:\t $%-15.2f\n", cashValue());
            System.out.printf("Dollars:\t\t\t\t %-15d\n", numberOfOneDollarBills);
            System.out.printf("Quarters:\t\t\t\t %-15d\n", numberOfQuarters);
            System.out.printf("Dimes:\t\t\t\t\t %-15d\n", numberOfDimes);
            System.out.printf("Nickels:\t\t\t\t %-15d\n", numberOfNickels);
            System.out.printf("Pennies:\t\t\t\t %-15d\n", numberOfPennies);
            System.out.println("==========================================");
            System.out.println("==========================================");
            System.out.println();
        }else {
            System.out.println("==========================================");
            System.out.println("Register Cash Info");
            System.out.println("==========================================");
            System.out.println("Access Level:\t\t\t Not Valid by " + personal);
            System.out.println("");
        }
    }


    public void buyApple(Apple apple, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Apple");
        System.out.println("==========================================");
        System.out.printf("Apple Price:\t\t\t $%-15.2f\n" , apple.price() );
        System.out.printf("Payment:\t\t\t\t $%-15.2f\n" , payment.paymentValue() );

        if(payment.paymentValue()<apple.price()){
            double shortAmount = apple.price()- payment.paymentValue();
            System.out.printf("You need:\t\t\t\t $%-15.2f\n",shortAmount );
            System.out.println("");
            System.out.println("Sorry but you do not have enough money to buy the Apple");
            System.out.println("==========================================");
            System.out.println("\n");
        }else if(payment.paymentValue()>= apple.price()){
            giveChange(apple.price(), payment);
        }

    }//end buyApple()

    public void buySandwich(Sandwich sandwich, Payment payment){
        System.out.println("==========================================");
        System.out.println("Register Buy Sandwich");
        System.out.println("==========================================");
        System.out.printf("Sandwich Price:\t\t\t $%-15.2f\n" , sandwich.getPrice() );
        System.out.printf("Payment:\t\t\t\t $%-15.2f\n" , payment.paymentValue() );


        if(payment.paymentValue()<sandwich.getPrice()){

            double shortAmount = sandwich.getPrice()- payment.paymentValue();
            System.out.printf("You need:\t\t\t\t $%-15.2f\n", shortAmount);
            System.out.println("");
            System.out.println("Sorry but you do not have enough money to buy the Sandwich");
            System.out.println("==========================================");
            System.out.println("\n");

        }else{
            giveChange(sandwich.getPrice(),payment);
        }

    }//end buySandwich()

    private void giveChange(double price, Payment payment){

        numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
        numberOfQuarters += payment.getNumberOfQuarters();
        numberOfDimes += payment.getNumberOfDimes();
        numberOfNickels += payment.getNumberOfNickels();
        numberOfPennies += payment.getNumberOfPennies();

        // calculate needed change
        double neededChange = payment.paymentValue()-price;
        int neededChangeWhole = (int)Math.round(neededChange * 100);
        System.out.printf("NeededChange:\t\t\t $%-15.2f\n", neededChange);


        int rc = (int)(neededChange*100);
        int dollars = rc/100;
        rc = rc%100;

        int quarters = rc/25;
        rc = rc%25;

        int dimes = rc/10;
        rc = rc%10;

        int nickels = rc/5;
        rc = rc%5;

        int pennies = rc/1;
        rc = rc%1;

        numberOfOneDollarBills -= dollars;
        numberOfQuarters -= quarters;
        numberOfDimes -= dimes;
        numberOfNickels -= nickels;
        numberOfPennies -= pennies;

        System.out.printf("Dollars:\t\t\t\t %-15d\n", dollars);
        System.out.printf("Quaters:\t\t\t\t %-15d\n", quarters);
        System.out.printf("Dime:\t\t\t\t\t %-15d\n", dimes);
        System.out.printf("Nickels:\t\t\t\t %-15d\n", nickels);
        System.out.printf("Pennies:\t\t\t\t %-15d\n", pennies);


    }//end giveChange
}
