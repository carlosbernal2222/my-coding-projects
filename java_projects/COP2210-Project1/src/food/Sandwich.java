package food;

public class Sandwich {

    //----------------------------------------------------------
    // Instant variables
    //----------------------------------------------------------
    private String bread;
    private boolean meat;
    private boolean cheese;
    private boolean veggies;
    private double price;

    //----------------------------------------------------------
    // Constructors
    //----------------------------------------------------------
    public Sandwich(boolean meat, boolean cheese, boolean veggies) {
        bread = "White";

        if(meat==true && cheese==true &&veggies==true){
            price=7.99;
        }else if(meat==true&&cheese==true&&veggies==false){
            price=7.59;
        }else if(meat==true&&cheese==false&&veggies==true){
            price=7.09;
        }else if(meat==true&&cheese==false&&veggies==false){
            price=6.89;
        }else if(meat==false&&cheese==true&&veggies==true){
            price=5.99;
        }else if(meat==false&&cheese==true&&veggies==false){
            price=5.59;
        }else if(meat==false&&cheese==false&&veggies==true){
            price=5.09;
        }else if(meat==false&&cheese==false&&veggies==false){
            price=4.99;
        }

        this.meat = meat;
        this.cheese = cheese;
        this.veggies = veggies;
    }

    public Sandwich(String bread,
                    boolean meat,
                    boolean cheese,
                    boolean veggies) {

        this(meat, cheese, veggies);
        this.bread = bread;
    }

    //----------------------------------------------------------
    // Setters and Getters
    // IMPORTANT: match the UML Diagram
    //----------------------------------------------------------

    public String getBread() {
        return bread;
    }

    public double getPrice() {
        return price;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isMeat(){
        return true;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isCheese(){
        return true;
    }

    public void setVeggies(boolean veggies) {
        this.veggies = veggies;
    }

    public boolean isVeggies(){
        return true;
    }

    //----------------------------------------------------------
    // Utility methods
    //----------------------------------------------------------

    public void displayInfo(){

         System.out.println("==========================================");
         System.out.println("Sandwich Info");
         System.out.println("==========================================");
         System.out.printf("Bread:\t\t\t\t\t %-15s\n", bread);
         System.out.printf("Meat:\t\t\t\t\t %-15b \n", meat);
         System.out.printf("Cheese:\t\t\t\t\t %-15b \n", cheese);
         System.out.printf("Veggies:\t\t\t\t %-15b \n", veggies);
         System.out.printf("Price:\t\t\t\t\t $%-9.2f \n", price);
   }
}//end Sandwich class
