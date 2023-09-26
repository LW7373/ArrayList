/*
Moses Dong, Lindsay Wang, and Nicholas Xu
Schenk
AP CSA - Period 7
Glizzy Goblin - Sausage Container Class
25 September 2023
*/

package dongwangxu.seven;

import dongwangxu.seven.MeatTypeEnum.MeatType;
import dongwangxu.seven.Sausage;

public class PackBox{

    // Class fields
    private String material;
    private double length;
    private double width;
    private double height;
    private int numSausageLinks;
    private boolean isShipped;
    // Moses added shippingStatus variable, implemented it into constructors, toString, and Main
    private String shippingStatus;
    private Sausage[] sausageArray;

    // CONSTRUCTORS

    //Default Constructor - Moses
    public PackBox(){
        this.material = "Plastic";
        this.length = 10.0;
        this.width = 10.0;
        this.height = 10.0;
        this.numSausageLinks = 10;
        this.isShipped = false;
        this.shippingStatus = "In Warehouse";
        this.sausageArray = new Sausage[100];//Far greater than necessary, also not mod 3
    }

    // Partial Constructor 1 (The Box Itself) - Moses
    public PackBox(String material, double length, double width, double height){
        this.material = material;
        this.length = length;
        this.width = width;
        this.height = height;
        this.numSausageLinks = 10;
        this.isShipped = false;
        this.shippingStatus = "In Warehouse";
        this.sausageArray = new Sausage[100];
    }

    // Partial Constructor 2 - Nicholas
    public PackBox(String material, int numSausageLinks, boolean isShipped, String shippingStatus, Sausage[] sausageArray){
        this.material = material;
        this.length = 8;
        this.width = 12;
        this.height = 9;
        this.numSausageLinks = numSausageLinks;
        this.isShipped = isShipped;
        this.shippingStatus = shippingStatus;
        this.sausageArray = sausageArray;
    }

    // Full Constructor - Lindsay
    public PackBox(String material, double length, double width, double height, int numSausageLinks, boolean isShipped, String shippingStatus, Sausage[] sausageArray) {
        this.material = material;
        this.length = length;
        this.width = width;
        this.height = height;
        this.numSausageLinks = numSausageLinks;
        this.isShipped = isShipped;
        this.shippingStatus = shippingStatus;
        this.sausageArray = sausageArray;
    }

    // GETTERS AND SETTERS - Nicholas

    // material
    public String getMaterial(){
        return this.material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    // length
    public double getLength(){
        return this.length;
    }

    public void setLength(double length){
        this.length = length;
    }

    // width
    public double getWidth(){
        return this.width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    // height
    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    // numSausageLinks
    public int getNumSausageLinks(){
        return this.numSausageLinks;
    }

    public void setNumSausageLinks(int numSausageLinks){
        this.numSausageLinks = numSausageLinks;
    }

    // isShipped
    public boolean isShipped(){ // Returned to normal from isFull
        return this.isShipped;
    }

    public void setShipped(boolean isShipped){
        this.isShipped = isShipped;
    }

    // shippingStatus
    public String getShippingStatus(){ // Changed respectively - Moses
        return this.shippingStatus;
    }

    public void setShippingStatus(String shippingStatus){
        this.shippingStatus = shippingStatus;
    }

    // sausageArray
    public Sausage[] getSausageArray(){// Returned to normal - Moses
        return this.sausageArray;
    }

    public void setSausageArray(Sausage[] sausageArray){
        this.sausageArray = sausageArray;
    }

    // CRUD

    // Create a sausage - Lindsay
    public void AddSausage(Sausage newSausage){        
        int arrayLen =  this.sausageArray.length;
        Sausage[] sausageArrayNew = new Sausage[arrayLen + 1];
        System.arraycopy(sausageArray, 0, sausageArrayNew, 0, arrayLen);
        sausageArrayNew[arrayLen] = newSausage; 
        this.setSausageArray(sausageArrayNew);
    }

    // Read all sausages - Lindsay
    public void ReadAllSausages(){
        int arrayLen = this.sausageArray.length;
        for (int i = 0; i < arrayLen; i++){
            System.out.println("Sausage " + (i + 1) + ": " + sausageArray[i]);
        }
    }

    // Read a specific sausage - Lindsay, modified by Moses
    public String ReadOneSausage(int selectedSausage){
        String readOut = "Sausage " + (selectedSausage) + ": " + sausageArray[selectedSausage - 1];
        System.out.println(readOut);
        return readOut;
    }

    // Update a sausage - Lindsay
    public void ChangeSausage(int selectedSausage, Sausage newSausage){
        this.sausageArray[selectedSausage - 1] = newSausage;
        this.setSausageArray(sausageArray);
        System.out.println("\nUpdated Sausage " + selectedSausage + "\n");
    }

    // Delete a sausage - Lindsay
    public void DeleteSausage(int selectedSausage){
        int arrayLen =  this.sausageArray.length;
        // Original Size Changing
        // Sausage[] sausageArrayNew = new Sausage[arrayLen - 1];//Not necessary but cool :)
        // for(int i = 0, k = 0; i < arrayLen; i++){
        //     if (i != (selectedSausage - 1)){
        //         sausageArrayNew[k] = this.sausageArray[i];
        //         k++;
        //     }
        // }
        // this.setSausageArray(sausageArrayNew);
        
        //Modification by Moses, disables changing array size for better or for worse
        this.sausageArray[selectedSausage - 1] = new Sausage();//Use default

        System.out.println("\nDeleted Sausage " + selectedSausage + "\n");
        for (int i = 0; i < arrayLen - 1; i++){
            System.out.println("Sausage " + (i + 1) + ": " + sausageArray[i]);
        }
    }

    // toString display method - Nicholas
    public String toString(){
        String s = "PackBox Stats\n";
        s += "============================\n";
        s += "Material: " + this.material + "\n";
        s += "Length (inches): " + this.length + "\n";
        s += "Width (inches): " + this.width + "\n";
        s += "Height (inches): " + this.height + "\n";
        s += "NumSausageLinks: " + this.numSausageLinks + "\n";
        s += "Shipped? " + this.isShipped + "\n";
        s += "Shipping Status: " + this.shippingStatus; //Small Modification - Moses
        return s;
    }
}
