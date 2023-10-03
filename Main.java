/*
Moses Dong, Lindsay Wang, and Nicholas Xu
Schenk
AP CSA - Period 7
Glizzy Goblin - Main
3 October 2023
*/

package dongwangxu.seven;
import java.util.Scanner;
import java.util.ArrayList;
import dongwangxu.seven.MeatTypeEnum.MeatType;
import dongwangxu.seven.Sausage;
import dongwangxu.seven.SausagePackage;

// Note: Moses implemented new shippingStatus field into all aspects

public class Main{
  
  static Scanner scan = new Scanner(System.in);
  private static SausagePackage fullSausagePackage = new SausagePackage();
  private static ArrayList<Sausage> sausageArray = new ArrayList<Sausage>(); 

  // Main Method - Moses (Lindsay references kept around)
  public static void main(String[] args) {
    // Heavily Modified from Original
    // Create sausages to put in sausageArray - Lindsay
    sausageArray.ensureCapacity(12);
    for (int saIndex = 0; saIndex < 1; saIndex++){
      sausageArray.add(saIndex, new Sausage());
      //nicholas added these for the sake of dietary restriction filter testing
      sausageArray.add(saIndex + 1, new Sausage("Perfect Piggy Pizzazz", MeatType.pork, 1.50, 4.49, 4.5, 75, true));
      sausageArray.add(saIndex + 2, new Sausage("Vegan Sausage Delight", MeatType.vegan, 1.75, 5.49, 4.75, 40, true));
      sausageArray.add(saIndex + 3, new Sausage("Fish Fiend Fingers", MeatType.fish, 1.25, 4.29, 4.0, 50, true));
      sausageArray.add(saIndex + 4, new Sausage("Beefy Delight", MeatType.beef, 1.60, 4.99, 4.2, 60, true));
      sausageArray.add(saIndex + 5, new Sausage("Chicken Sensation", MeatType.chicken, 1.45, 4.79, 4.3, 70, true));
      sausageArray.add(saIndex + 6, new Sausage("Tasty Turkey Twist", MeatType.turkey, 1.55, 5.19, 4.4, 45, true));
      sausageArray.add(saIndex + 7, new Sausage("Luscious Lamb Lovers", MeatType.lamb, 1.70, 5.99, 4.7, 55, true));
      sausageArray.add(saIndex + 8, new Sausage("Mystery Meat Madness", MeatType.mystery, 1.80, 6.29, 4.8, 30, true));
      sausageArray.add(saIndex + 9, new Sausage("Porky Paradise", MeatType.pork, 1.70, 5.49, 4.6, 65, true));
      sausageArray.add(saIndex + 10, new Sausage("Chicken Charm", MeatType.chicken, 1.45, 4.69, 4.1, 80, true));
      sausageArray.add(saIndex + 11, new Sausage("Fishy Flavor Fiesta", MeatType.fish, 1.30, 4.39, 4.5, 45, true));
    }

    // Create the SausagePackage - Lindsay
    fullSausagePackage = new SausagePackage("Plastic", 25.5, 3.5, 40.0, 12, false, "In Warehouse", sausageArray);

    // Clear Screen - Nicholas added all clear screen lines
    System.out.print("\033\143");

    // Display Menu - Lindsay
    showMainMenu();    
    scan.close();
  }

  // Main Menu System - Moses (Lindsay references kept around)
  public static void showMainMenu() {
    System.out.println("--- MAIN MENU ---");
    System.out.println("1. Add Sausage");
    System.out.println("2. Read All Sausages");
    System.out.println("3. Read One Sausage");
    System.out.println("4. Update Sausage");
    System.out.println("5. Delete Sausage");
    System.out.println("6. Display Other Box Stats");
    System.out.println("7. Read Sausages Aligning With A Particular Diet");
    System.out.println("8. Update All Sausages (Manual)");
    System.out.println("0. Exit");

    // Get user input - Lindsay
    System.out.print("Enter your Choice: ");
    int option = 0;
    boolean nNum;
    // Valid input must be a number    
    do { 
      try{
        // Validate non Number
        if (!scan.hasNextInt() ){
        System.out.print("Enter your Choice: ");
        scan.next();
        nNum = true;
        }      
        option = scan.nextInt();
        // Validate number range
        if (!((option >= 0)&&(option <= 7))){
          System.out.print("Enter your Choice: ");          
          nNum = true;
        }else{
          nNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Enter your Choice: ");     
        scan.next(); 
        nNum = true;
      }      
    } while (nNum); 
    
    // Switch to do a specific operation based on the user's input - Lindsay
    switch (option) {
      // If 1, create a sausage - Lindsay
      case 1:
        System.out.print("\033\143");
        System.out.println("Selected Add\n");
        Sausage createdSausage = InputSausageFields();
        MainAddSausage(createdSausage);
        System.out.println("");
        fullSausagePackage.ReadAllSausages();
        showMainMenu();
        break;
      // If 2, read all sausages - Lindsay
      case 2:
        System.out.print("\033\143");
        System.out.println("Selected Read All\n");
        fullSausagePackage.ReadAllSausages();
        showMainMenu();
        break;
      // If 3, read a specific sausage - Lindsay
      case 3:
        System.out.print("\033\143");
        System.out.println("Selected Read One\n");
        MainReadOneSausage();
        showMainMenu();
        break;
      // If 4, update a sausage - Lindsay
      case 4:
        System.out.print("\033\143");
        System.out.println("Selected Update\n");
        Sausage updatedSausage = InputSausageFields();
        System.out.println("");
        MainUpdateSausage(updatedSausage);
        fullSausagePackage.ReadAllSausages();
        showMainMenu();
        break;
      // If 5, delete a sausage - Lindsay
      case 5:
        System.out.print("\033\143");
        System.out.println("Selected Delete\n");
        MainDeleteSausage();
        showMainMenu();
        break;
      // If 6, display other box (container) stats
      case 6:
        System.out.print("\033\143");
        System.out.println("Selected Display Box\n");
        System.out.println(fullSausagePackage.toString() + "\n");
        showMainMenu();
        break;
      // If 7, display compatible sausages
      //nicholas 
      case 7:
        System.out.print("\033\143");
        System.out.println("Sausages in Alignment With Diet\n");
        MainFilterDiet();
        break;
      //nicholas end
      // If 8, Special (Manual) Update - Moses
      case 8:
        System.out.print("\033\143");
        System.out.println("Sausages in Alignment With Diet\n");
        fullSausagePackage.manualSausageUpdate();
      // If 0, terminate program - Lindsay
      case 0:
        System.out.print("\033\143");
        System.out.println("Terminating...");
        System.exit(0);
        break;
      // Backup for if the user inputs an invalid option and try-catches don't work
      default:
        System.out.println("Invalid Option");
        showMainMenu();
    }
  }


  // Allows user to input sausage fields (used for create and update) - Lindsay
  public static Sausage InputSausageFields() {
    String sProductName;
    MeatType SMeatType = MeatType.beef;
    double sProductionCost;
    double sSellingPrice;
    double sSausageLength;
    int sFatPercentage;
    boolean sIsCooked = true;
    Sausage newSausage = new Sausage();
    
    // User inputs values for the sausage - Lindsay
    System.out.println("Please input the values for your sausage specs below:\n");

    // sProductName - Lindsay
    System.out.print("Product Name: ");
    sProductName = scan.next();

    // Do whiles used for catching out-of-bounds values - Lindsay

    // SMeatType - Lindsay
    System.out.print("Meat Filling (1. beef, 2. pork, 3. chicken, 4. fish, 5. turkey, 6. lamb, 7. vegan, 8. mystery): ");
    int switchFillingVal = 0;
    boolean nNum;
    // Valid input must be a number    
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
        System.out.print("Meat Filling: ");
        scan.next();
        nNum = true;
        }      
        switchFillingVal = scan.nextInt();
        // Validate number range
        if ((switchFillingVal > 8) || (switchFillingVal <= 0)){
          System.out.print("Meat Filling: ");          
          nNum = true;
        } else {
          nNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Meat Filling: ");     
        scan.next(); 
        nNum = true;
      }      
    } while (nNum); 
    
    // Set SMeatType based on the user int input - Lindsay
    switch (switchFillingVal) {
      case 1:
        SMeatType = MeatType.beef;
        break;
      case 2:
        SMeatType = MeatType.pork;
        break;
      case 3:
        SMeatType = MeatType.chicken;
        break;
      case 4:
        SMeatType = MeatType.fish;
        break;
      case 5:
        SMeatType = MeatType.turkey;
        break;
      case 6:
        SMeatType = MeatType.lamb;
        break;
      case 7:
        SMeatType = MeatType.vegan;
        break;
      case 8:
        SMeatType = MeatType.mystery;
        break;
      // Backup for if the user inputs an invalid option and try-catches don't work
      default:
        SMeatType = MeatType.pork;
        System.out.println("Invalid entry, default set to pork.");
        break;
    }

    // sProductionCost - Lindsay
    System.out.print("Production Cost: ");
    sProductionCost = 0;
    boolean proDouble;
    // Validate double number
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextDouble()){
          System.out.print("Production Cost: ");
          scan.next();
          proDouble = true;
        }
        sProductionCost = scan.nextDouble();
        // Validate number range
        if (sProductionCost < 0){
          System.out.print("Production Cost: ");          
          proDouble = true;
        } else {
          proDouble = false;
        }
      }
      catch(Exception e){
        System.out.print("Production Cost: ");     
        scan.next();
        proDouble = true;
      }
    } while (proDouble);
    
    // SellingPrice - Lindsay
    System.out.print("Selling Price: ");
    sSellingPrice = 0;
    boolean sellDouble;
    // Validate double number
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextDouble()){
          System.out.print("Selling Price: ");
          scan.next();
          sellDouble = true;
        }      
        sSellingPrice = scan.nextDouble();
        // Validate number range
        if (sSellingPrice < 0){
          System.out.print("Selling Price: ");          
          sellDouble = true;
        } else {
          sellDouble = false;
        }
      }
      catch(Exception e){
        System.out.print("Selling Price: ");     
        scan.next(); 
        sellDouble = true;
      }      
    } while (sellDouble);   
    
    // SausageLength - Lindsay
    System.out.print("Sausage Length: ");   
    sSausageLength = 0;
    boolean lenDouble;
    // Validate double number
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextDouble()){
          System.out.print("Sausage Length: ");
          scan.next();
          lenDouble = true;
        }      
        sSausageLength = scan.nextDouble();
        // Validate number range
        if (sSausageLength <= 0){
          System.out.print("Sausage Length: ");          
          lenDouble = true;
        } else {
          lenDouble = false;
        }
      }
      catch(Exception e){
        System.out.print("Sausage Length: ");     
        scan.next(); 
        lenDouble = true;
      }      
    } while (lenDouble);

    // sFatPercentage - Lindsay
    System.out.print("Fat Percentage (up to 50): ");
    sFatPercentage = 0;
    boolean fatNum;
    // Validate double number
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
          System.out.print("Fat Percentage (up to 50): ");
          scan.next();
          fatNum = true;
        }      
        sFatPercentage = scan.nextInt();
        // Validate number range
        if ((sFatPercentage < 0 )|| (sFatPercentage > 50)){
          System.out.print("Fat Percentage (up to 50): ");          
          fatNum = true;
        } else {
          fatNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Fat Percentage (up to 50):");     
        scan.next(); 
        fatNum = true;
      }      
    } while (fatNum);     
     
    // sIsCooked - Lindsay
    System.out.print("Cooked (1. true, 2. false)? ");
    int switchCookedVal = 0;
    boolean cookNum;
    // Valid input must be a number    
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
        System.out.print("Cooked (1. true, 2. false)? ");
        scan.next();
        cookNum = true;
        }      
        switchCookedVal = scan.nextInt();
        // Validate number range
        if ((switchCookedVal > 2) || (switchCookedVal <= 0)){
          System.out.print("Cooked (1. true, 2. false)? ");          
          cookNum = true;
        } else {
          cookNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Cooked (1. true, 2. false)? ");     
        scan.next(); 
        cookNum = true;
      }      
    } while (cookNum);
    switch (switchCookedVal) {
      case 1:
        sIsCooked = true;
        break;
      case 2:
        sIsCooked = false;
        break;
      // Backup for if the user inputs an invalid option and try-catches don't work
      default:
        sIsCooked = false;
        System.out.println("Invalid entry, default set to false.");
        break;
    } 
    
    // Create a sausage based on input values - Lindsay
    newSausage = new Sausage(sProductName, SMeatType, sProductionCost, sSellingPrice, sSausageLength, sFatPercentage, sIsCooked);
    return newSausage;
  }

  // CRUD

  // NOTE FOR ALL METHODS BELOW: USER-INPUTTED SAUSAGE NUMBER IS "NATURAL" INDEX (STARTING FROM 1, NOT 0)

  // Add a sausage (uses sausage created in InputSausageFields()) - Lindsay
  public static void MainAddSausage(Sausage newSausage) {
    fullSausagePackage.AddSausage(newSausage);
  }

 
  // Read a specific sausage - arrayList by Nicholas, structure by Lindsay
  public static void MainReadOneSausage() {
    int selectedSausage = 0;
    int arrayLength = fullSausagePackage.getSausageArrayList().size();
    System.out.print("Which sausage would you like to view? ");
    boolean readOneNum;
    // Valid input must be a number    
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
          System.out.print("Which sausage would you like to view? ");
          scan.next();
          readOneNum = true;
        }      
        selectedSausage = scan.nextInt();
        // Validate number range
        if ((selectedSausage > arrayLength) || (selectedSausage <= 0)){ // Lindsay debugged by checking/changing parameters
          System.out.print("Which sausage would you like to view? ");
          readOneNum = true;
        } else {
          readOneNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Which sausage would you like to view? ");
        scan.next();
        readOneNum = true;
      }      
    } while (readOneNum);
    
    System.out.println("");
    fullSausagePackage.ReadOneSausage(selectedSausage);
  }

  // Update a sausage - arraylist by Nicholas, structure by Lindsay
  public static void MainUpdateSausage(Sausage newSausage){
    int selectedSausage = 0;
    int arrayLength = fullSausagePackage.getSausageArrayList().size();
    System.out.print("Which sausage would you like to update? ");
    boolean updateNum;
    // Valid input must be a number    
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
          System.out.print("Which sausage would you like to update? ");
          scan.next();
          updateNum = true;
        }      
        selectedSausage = scan.nextInt();
        // Validate number range
        if ((selectedSausage > arrayLength) || (selectedSausage <= 0)){ // Lindsay debugged by checking/changing parameters
          System.out.print("Which sausage would you like to update? ");
          updateNum = true;
        } else {
          updateNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Which sausage would you like to update? ");
        scan.next();
        updateNum = true;
      }      
    } while (updateNum);
    
    fullSausagePackage.ChangeSausage(selectedSausage, newSausage);
  }
  
  // Delete a sausage - arraylist by Moses, structure by Lindsay
  public static void MainDeleteSausage() {
    int selectedSausage = 0;
    int arrayLength = fullSausagePackage.getSausageArrayList().size();
    System.out.print("Which sausage would you like to delete? ");

    boolean deleteIndex;
    do { // Valid input must be a number    
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
          System.out.print("Which sausage would you like to delete? ");
          scan.next();
          deleteIndex = true;
        }      
        selectedSausage = scan.nextInt();
        // Validate number range
        if ((selectedSausage > arrayLength) || (selectedSausage <= 0)){ // Lindsay debugged by checking/changing parameters
          System.out.print("Which sausage would you like to delete? ");
          deleteIndex = true;
        } else {
          deleteIndex = false;
        }
      }
      catch(Exception e){
        System.out.print("Which sausage would you like to delete? ");
        scan.next();
        deleteIndex = true;
      }      
    } while (deleteIndex);

    fullSausagePackage.DeleteSausage(selectedSausage);
  }

  //crud end

  //extra functions 
  //MainFilterDiet - Nicholas 
  public static void MainFilterDiet(){
    System.out.print("Which of the following dietary restrictions would you like to apply? (1. kosher, 2. halal, 3. vegan, 4. pescitarian): ");
    int dietVal = 0;
    boolean dietBool;
    do{
      try{
        if(!scan.hasNextInt()){
          System.out.print("Dietary Restriction: ");
          scan.next();
        }
        dietVal = scan.nextInt();
        if ((dietVal > 4) || (dietVal <= 0)){
          System.out.print("Dietary Restriction: ");          
          dietBool = true;
        } else {
          dietBool = false;
        }
      }
      catch(Exception e){
        System.out.print("Dietary Restriction: ");     
        scan.next(); 
        dietBool = true;
      }      
    } while (dietBool); 
    switch (dietVal){
        case 1:
            for (Sausage sausage : sausageArray) {
                if (!(sausage.getMeatType() == MeatType.pork) && !(sausage.getMeatType() == MeatType.mystery)) {
                    System.out.println(sausage.toString());
                }
            }
                
        case 2:
            for (Sausage sausage : sausageArray) {
                if (!(sausage.getMeatType() == MeatType.pork) && !(sausage.getMeatType() == MeatType.mystery)) {
                    System.out.println(sausage.toString());
                }
            }
        case 3:
            for (Sausage sausage : sausageArray) {
                if ((sausage.getMeatType() == MeatType.vegan)) {
                    System.out.println(sausage.toString());
                }
            }
        case 4:
            for (Sausage sausage : sausageArray) {
                if ((sausage.getMeatType() == MeatType.vegan) || (sausage.getMeatType() == MeatType.fish)) {
                    System.out.println(sausage.toString());
                }
            }
        }
  }
  
}
