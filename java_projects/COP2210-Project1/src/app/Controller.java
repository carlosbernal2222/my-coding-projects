//=============================================================================
// PROGRAMMER:  Carlos Bernal
// PANTHER ID:  6197797
//
// CLASS:        COP2210
// SECTION:      U01
// SEMESTER:     Spring 2022
// CLASSTIME:    T/TH 6:25-9:00 pm
//
// Project:      Project 1
// DUE:          01/00/2022
//
// CERTIFICATION:   I understand FIU’s academic policies, and I certify that this work is my
//                                 own and that none of it is the work of any other person.
//=============================================================================

package app;

import food.Apple;
import food.Sandwich;
import machine.Register;
import transactions.Payment;

public class Controller {
    public static void main(String[]args){

        //yourInfoHeader method
        yourInfoHeader();

        //RegisterInfo
        Register register = new Register(15,20,10,20,50);
        register.cashInfo("Manager");
        register.cashInfo("Staff");

        //GrannySmithApple
        Apple grannySmith = new Apple("Granny Smith", 1.51,140);
        grannySmith.displayInfo();
        Payment applePayment1 = new Payment(10,0,0,0,47);
        applePayment1.displayInfo();
        register.buyApple(grannySmith,applePayment1);
        register.cashInfo("Manager");


        //macintoshApple
        Apple macintosh = new Apple("Macintosh",150,1.70);
        macintosh.displayInfo();
        Payment applePayment2 = new Payment(0,2,0,0,0);
        applePayment2.displayInfo();
        register.buyApple(macintosh,applePayment2);
        register.cashInfo("Manager");


        //SandwichTest
        Sandwich sandwich = new Sandwich(true,true,true);
        sandwich.displayInfo();
        Payment sandwichPayment1 = new Payment(5,2,1,1,2);
        sandwichPayment1.displayInfo();
        register.buySandwich(sandwich,sandwichPayment1);
        register.cashInfo("Manager");


        // All Sandwich combinations
        boolean meat = true;
        boolean cheese = true;
        boolean veggies = true;

        System.out.println("");

        for(int i = 1; i<=8; i++){
            if(i<=4) {
                meat = true;
            }else{
                meat = false;
            }
            if(i<3){
                cheese = true;
            }else if(i<5){
                cheese = false;
            }else if(i<7){
                cheese = true;
            }else{
                cheese = false;
            }
            if(i%2 == 1){
                veggies = true;
            }else{
                veggies = false;
            }

            Sandwich sandwich1 = new Sandwich(meat,cheese,veggies);
            sandwich.displayInfo();
            Payment sandwichPayment2 = new Payment(10,0,0,0,0);
            sandwichPayment2.displayInfo();
            register.buySandwich(sandwich1,sandwichPayment2);
            register.cashInfo("Manager");
        }//end allSandwichCombinations

    }//main method end

    public static void yourInfoHeader() {

        System.out.println("============================================");
        System.out.println("PROGRAMMER: " + "Carlos Bernal");
        System.out.println("PANTHER ID: " + "6197797");
        System.out.println();
        System.out.println("CLASS: \t\t COP2210");
        System.out.println("SECTION: \t" + "Replace text");
        System.out.println("SEMESTER: \t" + "SPRING 2022");
        System.out.println("CLASSTIME: \t" + "6:25 pm-9:00 pm");
        System.out.println();
        System.out.println("Assigment: " + "COP2210-project1");
        System.out.println();
        System.out.println("CERTIFICATION: \nI understand FIU's academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("==============================================");
        System.out.println();
    }//end infoHeader method
}//end class controller

