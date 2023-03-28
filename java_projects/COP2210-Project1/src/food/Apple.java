package food;

public class Apple {
    //----------------------------------------------------------
    // Instant variables
    //----------------------------------------------------------
    private String type;
    private double weight;
    private double pricePreUnitWeight;

    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------
    public Apple(String type, double pricePreUnitWeight, double weightInGrams) {

        weight =  0.00220 * weightInGrams;

        this.type = type;
        this.pricePreUnitWeight = pricePreUnitWeight;
    }

    //----------------------------------------------------------
    // Setters and Getters
    //----------------------------------------------------------

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePreUnitWeight() {
        return pricePreUnitWeight;
    }

    public void setPricePreUnitWeight(double pricePreUnitWeight) {
        this.pricePreUnitWeight = pricePreUnitWeight;
    }


    //Utility methods
    public void displayInfo(){
    System.out.println("==========================================");
    System.out.println("Apple Info");
    System.out.println("==========================================");
    System.out.printf("Type:\t\t\t\t\t %-15s\n", type);
    System.out.printf("Weight:\t\t\t\t\t %-6.4f lbs\n", weight);
    System.out.printf("Price Pre Unit:\t\t\t %-10.2f\n", pricePreUnitWeight);
    System.out.printf("Price:\t\t\t\t\t $%-10.2f\n", price());
    }


    public double price(){
        double price = weight * pricePreUnitWeight;
        return price;
    }

}//end Apple class
