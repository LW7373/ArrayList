/*
Moses Dong, Lindsay Wang, and Nicholas Xu
Schenk
AP CSA - Period 7
Glizzy Goblin - Sausage Class
3 October 2023
*/

package dongwangxu.seven;
import dongwangxu.seven.MeatTypeEnum.MeatType;

public class Sausage{

    // Class fields
    private String productName;  
    private MeatType MeatType;
    private double productionCost;
    private double sellingPrice;
    private double sausageLength;
    private int fatPercentage;
    private boolean isCooked;

    // Default constructor - Lindsay
    public Sausage(){
        this.productName = "Classic Beef Sausage";
        this.MeatType = MeatType.beef;
        this.productionCost = 2.00;
        this.sausageLength = 4.0;
        this.fatPercentage = 70;
        this.isCooked = false;
    }

    // Partial constructor 1 - Nicholas
    public Sausage(String productName, double productionCost, double sausageLength){
        this.productName = "Mega Meat Mash";
        this.MeatType = MeatType.mystery;
        this.productionCost = 3.60;
        this.sausageLength = 12.0;
        this.fatPercentage = 75;
        this.isCooked = false;
    }

    // Partial constructor 2 - Nicholas
    public Sausage(String productName, MeatType meatType, double sausageLength, int fatPercentage){
        this.productName = "Diet Glizzy";
        this.MeatType = MeatType.chicken;
        this.productionCost = 3.10;
        this.sellingPrice = 7.49;
        this.sausageLength = 3.0;
        this.fatPercentage = 10;
        this.isCooked = false;
    }

    // Partial Constructor 3 - Moses (Nutrition)
    public Sausage(String productName, MeatType meatType, double sausageLength, int fatPercentage, boolean isCooked){
        this.productName = productName;
        this.MeatType = meatType;
        this.sausageLength = sausageLength;
        this.fatPercentage = fatPercentage;
        this.isCooked = isCooked;
        this.productionCost = 2.00;
        this.sellingPrice = 4.99;
    }

    // Partial Constructor 4 - Moses (Economics)
    public Sausage(String productName, MeatType meatType, double productionCost, double sellingPrice){
        this.productName = productName;
        this.MeatType = meatType;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
        this.sausageLength = 3.0;
        this.fatPercentage = 10;
        this.isCooked = true;
    }

    // Full constructor - Lindsay
    public Sausage(String productName, MeatType meatType, double productionCost, double sellingPrice, double sausageLength, int fatPercentage, boolean isCooked){
        this.productName = productName;
        this.MeatType = meatType;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
        this.sausageLength = sausageLength;
        this.fatPercentage = fatPercentage;
        this.isCooked = isCooked;
    }

    // Getters and setters - Lindsay
    public String getProductName(){
        // User validation goes here
        return this.getProductName();
    }

    public void setProductName(String productName){
        // User validation goes here
        this.productName = productName;
    }

    public MeatType getMeatType(){
        // User validation goes here
        return this.getMeatType();
    }

    public void setMeatType(MeatType meatType){
        // User validation goes here
        this.MeatType = meatType;
    }

    public double getProductionCost(){
        // User validation goes here
        return this.getProductionCost();
    }

    public void setProductionCost(double productionCost){
        // User validation goes here
        this.productionCost = productionCost;
    }

    public double getSellingPrice(){
        // User validation goes here
        return this.getSellingPrice();
    }

    public void setSellingPrice(double sellingPrice){
        // User validation goes here
        this.sellingPrice = sellingPrice;
    }

    public double getSausageLength(){
        // User validation goes here
        return this.getSausageLength();
    }

    public void setSausageLength(double sausageLength){
        // User validation goes here
        this.sausageLength = sausageLength;
    }

    public int getFatPercentage(){
        // User validation goes here
        return this.getFatPercentage();
    }

    public void setFatPercentage(int fatPercentage){
        // User validation goes here
        this.fatPercentage = fatPercentage;
    }

    public boolean isCooked(){
        // User validation goes here
        return this.isCooked;
    }

    public void setIsCooked(boolean isCooked){
        // User validation goes here
        this.isCooked = isCooked;
    }

    // toString display - Lindsay
    public String toString(){
        String s = "Sausage Stats\n";
        s += "============================\n";
        s += "Sausage Name: " + this.productName + "\n";
        s += "Meat Filling: " + this.MeatType + "\n";
        s += "Production Cost: " + this.productionCost + "\n";
        s += "Selling Price: " + this.sellingPrice + "\n";
        s += "Sausage Length (inches): " + this.sausageLength + "\n";
        s += "Fat Percentage: " + this.fatPercentage + "\n";
        s += "Cooked? " + this.isCooked + "\n";

        return s;
    }
}
