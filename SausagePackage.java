/*
Moses Dong, Lindsay Wang, and Nicholas Xu
Schenk
AP CSA - Period 7
Glizzy Goblin - Sausage Container Class
3 October 2023
*/

package dongwangxu.seven;
import dongwangxu.seven.MeatTypeEnum.MeatType;
import dongwangxu.seven.Sausage;
import java.util.ArrayList;

public class SausagePackage{

    // Class fields - Lindsay and Moses
    private String material;
    private double length;
    private double width;
    private double height;
    private int numSausageLinks;
    private boolean isShipped;
    private String shippingStatus; // Moses added shippingStatus variable, implemented it into constructors, toString, and Main
    private ArrayList<Sausage> sausageArrayList;

    // CONSTRUCTORS

    // Default Constructor - Moses
    public SausagePackage(){
        this.material = "Plastic";
        this.length = 10.0;
        this.width = 10.0;
        this.height = 10.0;
        this.numSausageLinks = 10;
        this.isShipped = false;
        this.shippingStatus = "In Warehouse";
        this.sausageArrayList = new ArrayList<Sausage>();
    }

    // Partial Constructor 1 (The Box Itself) - Moses
    public SausagePackage(String material, double length, double width, double height){
        this.material = material;
        this.length = length;
        this.width = width;
        this.height = height;
        this.numSausageLinks = 10;
        this.isShipped = false;
        this.shippingStatus = "In Warehouse";
        this.sausageArrayList = new ArrayList<Sausage>();
    }

    // Partial Constructor 2 - Nicholas
    public SausagePackage(String material, int numSausageLinks, boolean isShipped, String shippingStatus, ArrayList<Sausage> sausageArrayList){
        this.material = material;
        this.length = 10.0;
        this.width = 10.0;
        this.height = 10.0;
        this.numSausageLinks = numSausageLinks;
        this.isShipped = isShipped;
        this.shippingStatus = shippingStatus;
        this.sausageArrayList = sausageArrayList;
    }

    // Full Constructor - Lindsay
    public SausagePackage(String material, double length, double width, double height, int numSausageLinks, boolean isShipped, String shippingStatus, ArrayList<Sausage> sausageArrayList) {
        this.material = material;
        this.length = length;
        this.width = width;
        this.height = height;
        this.numSausageLinks = numSausageLinks;
        this.isShipped = isShipped;
        this.shippingStatus = shippingStatus;
        this.sausageArrayList = sausageArrayList;
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
    public boolean isShipped(){ 
        return this.isShipped;
    }

    public void setShipped(boolean isShipped){
        this.isShipped = isShipped;
    }

    // Start Moses Work
    // shippingStatus
    public String getShippingStatus(){ // Changed respectively - Moses
        return this.shippingStatus;
    }

    public void setShippingStatus(String shippingStatus){
        this.shippingStatus = shippingStatus;
    }

    // sausageArrayList
    public ArrayList<Sausage> getSausageArrayList(){// Returned to normal - Moses
        return this.sausageArrayList;
    }

    public void setSausageArrayList(ArrayList<Sausage> sausageArrayList){
        this.sausageArrayList = sausageArrayList;
    }
    // End Moses Work

    // CRUD

    // Create a sausage - Nicholas
    public void AddSausage(Sausage newSausage){
        this.sausageArrayList.add(newSausage);
    }

    // Read all sausages - arraylist by Nicholas, structure by Lindsay
    public void ReadAllSausages(){
        int arrayLen = this.sausageArrayList.size();
        for (int i = 0; i < arrayLen; i++){
            System.out.println("Sausage " + (i + 1) + ": " + sausageArrayList.get(i));
        }
    }

    // Read a specific sausage - arraylist by Nicholas, structure by Lindsay
    public String ReadOneSausage(int selectedSausage){
        String readOut = "Sausage " + (selectedSausage) + ": " + sausageArrayList.get(selectedSausage - 1);
        System.out.println(readOut);
        return readOut;
    }

    // Update a sausage - Moses
    public void ChangeSausage(int selectedSausage, Sausage newSausage){
        this.sausageArrayList.set(selectedSausage - 1, newSausage);
        System.out.println("\nUpdated Sausage " + selectedSausage + "\n");
    }

    // Delete a sausage - Moses
    public void DeleteSausage(int selectedSausage){     
        this.sausageArrayList.remove(selectedSausage - 1); // Lindsay debugged by editing index
        System.out.println("\nDeleted Sausage " + selectedSausage + "\n");
    }

    // toString display method - Nicholas
    public String toString(){
        String s = "Package Stats\n";
        s += "============================\n";
        s += "Material: " + this.material + "\n";
        s += "Length (inches): " + this.length + "\n";
        s += "Width (inches): " + this.width + "\n";
        s += "Height (inches): " + this.height + "\n";
        s += "NumSausageLinks: " + this.numSausageLinks + "\n";
        s += "Shipped? " + this.isShipped + "\n";
        s += "Shipping Status: " + this.shippingStatus; // Small Modification - Moses
        return s;
    }
}
