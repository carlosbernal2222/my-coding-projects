
//=============================================================================
// PROGRAMMER: Carlos Bernal
// PANTHER ID: 6197797
//
// CLASS: COP2210
// SECTION: Your class section: U01
// SEMESTER: The current semester: Spring 2022
// CLASSTIME: Your COP2210 course meeting time :T/TH 6:25-9:00 pm
//
// Project: Project 2
// DUE:
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my
// own and that none of it is the work of any other person.
//=============================================================================
package app;

import client.Person;
import goods.Item;
import payment.CreditCard;

import java.util.Random;

public class Controller {

    public static void main(String[] args) throws InterruptedException{

        Person john = new Person("John","Doe",
                                "1100 Brickell Ave",
                                "Apt 102","Miami",
                                "Florida");


       //Credit cards
        CreditCard masterCard = new CreditCard(john,"Master Card",
                                                    2500.00);
        //adding mastercard to creditCard array
        john.getCreditCards().add(masterCard);


        CreditCard ax = new CreditCard(john,"American Express",
                                                    5000.00);
        //adding americanExpress to creditCard array
        john.getCreditCards().add(ax);

        //Items for purchase
        Item cafeMocha = new Item("Food","Cafe Mocha",4.77);
        Item gucciSlipper = new Item("Clothing","Gucci Princetown",2650.00);
        Item coke = new Item("Food","Coke",1.99);
        Item airlinesTicket = new Item("Travel","MIA-SFO",823.26);

        //Purchases
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);
        ((CreditCard)john.getCreditCards().get(1)).makeCharge(gucciSlipper);

        //Transaction reports
        //Index 0=MasterCard 1=American Express
        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();
        ((CreditCard)john.getCreditCards().get(1)).transactionsReport();


        Random generator = new Random();

        // buying 7 cafeMocha using different credit cards
        for(int i=1; i<=7; i++){

            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));

            if(i%3==0){
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);
            }else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(cafeMocha);}
        }//end for


        // buying 5 airlinesTicket using different credit cards
        for(int i=1; i<=5; i++){

            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));

            if(i%2==0){
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(airlinesTicket);
            }else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(airlinesTicket);
            }
        }//end for

        // buying 10 cokes using different credit cards
        for(int i=1; i<=10; i++){

            // sleep for a random time upto 1 seconds
            Thread.sleep(generator.nextInt(1001));

            // this is use to randomly select a credit card
            int randomSelectCard = generator.nextInt(2);

            if(randomSelectCard == 0){
                System.out.println("randomSelectedCard: MasterCard");
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(coke);
            }else {
                System.out.println("randomSelectedCard: American Express");
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(coke);
            }
        }//end for

        // john is running a transaction Report on his masterCard
        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();

        // john is running a transaction Report on his American Express
        ((CreditCard)john.getCreditCards().get(1)).transactionsReport();


        // john is running displayInfo method
        john.displayInfo();

    }//end main

}
