/*
Moses Dong, Lindsay Wang, and Nicholas Xu
Schenk
AP CSA - Period 7
Glizzy Goblin - Main
25 September 2023
*/

package dongwangxu.seven;

import java.util.Scanner;

import dongwangxu.seven.MeatTypeEnum.MeatType;
import dongwangxu.seven.Sausage;
import dongwangxu.seven.PackBox;

// Note: Moses implemented new shippingStatus field into all aspects
// Note: arrayCapacity changing commented out due to java array limitations - Moses

public class Main{
  
  static Scanner scan = new Scanner(System.in);
  private static PackBox fullPackBox = new PackBox();
  static int arrayCapacity = 12;
  private static Sausage[] sausageArray = new Sausage[arrayCapacity];

  public static void main(String[] args) {

    // Create sausages to put in sausageArray - Lindsay
    for (int saIndex = 0; saIndex < arrayCapacity; saIndex += 3){
      sausageArray[saIndex] = new Sausage();
      sausageArray[saIndex + 1] = new Sausage("Cheery Chump Chick", MeatType.chicken, 1.00, 3.99, 5.0, 80, true);
      sausageArray[saIndex + 2] = new Sausage("Perfect Piggy Pizzazz", MeatType.pork, 1.50, 4.49, 4.5, 75, true);
    }
    
    // Create a PackBox - Lindsay
    fullPackBox = new PackBox("plastic", 25.5, 3.5, 40.0, 12, false, "In Warehouse", sausageArray);

    // Clear Screen - Nicholas added all clear screen lines
    System.out.print("\033\143");

    // Display Menu - Lindsay
    showMainMenu();    
    scan.close();
  }

  // Main Menu System - Lindsay
  public static void showMainMenu() {
    System.out.println("--- MAIN MENU ---");
    System.out.println("1. Add Sausage");
    System.out.println("2. Read All Sausages");
    System.out.println("3. Read One Sausage");
    System.out.println("4. Update Sausage");
    System.out.println("5. Delete Sausage");
    System.out.println("6. Display Other Box Stats");
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
        if ((option > 6) || (option < 0)){
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
        fullPackBox.ReadAllSausages();
        showMainMenu();
        break;
      // If 2, read all sausages - Lindsay
      case 2:
        System.out.print("\033\143");
        System.out.println("Selected Read All\n");
        fullPackBox.ReadAllSausages();
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
        fullPackBox.ReadAllSausages();
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
        System.out.println(fullPackBox.toString() + "\n");
        showMainMenu();
        break;
      // If 0, terminate program - Lindsay
      case 0:
        System.out.print("\033\143");
        System.out.println("Terminating...");
        System.exit(0);
        break;
      // Backup for if the user inputs an invalid option and try-catches don't work
      default:
        System.out.println("Invalid option!");
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
    System.out.print("Meat Filling (1. beef, 2. pork, 3. chicken, 4. venison, 5. turkey, 6. lamb, 7. vegan, 8. mystery): ");
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
        SMeatType = MeatType.venison;
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

  // Add a sausage (uses sausage created in InputSausageFields()) - Lindsay
  public static void MainAddSausage(Sausage newSausage) {
    fullPackBox.AddSausage(newSausage);
    //arrayCapacity++;
  }

  // NOTE FOR ALL METHODS BELOW: USER-INPUTTED SAUSAGE NUMBER IS "NATURAL" INDEX (STARTING FROM 1, NOT 0)

  // Read a specific sausage - Lindsay
  public static void MainReadOneSausage() {
    int selectedSausage = 0;
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
        if ((selectedSausage > arrayCapacity) || (selectedSausage <= 0)){
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
    fullPackBox.ReadOneSausage(selectedSausage);
  }

  // Update a sausage - Lindsay
  public static void MainUpdateSausage(Sausage newSausage){
    int selectedSausage = 0;
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
        if ((selectedSausage > arrayCapacity) || (selectedSausage <= 0)){
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
    
    fullPackBox.ChangeSausage(selectedSausage, newSausage);
  }

  // Delete a sausage - Lindsay
  public static void MainDeleteSausage() {
    int selectedSausage = 0;
    System.out.print("Which sausage would you like to delete? ");
    boolean deleteNum;
    // Valid input must be a number    
    do { 
      try{
        // Validate non-number
        if (!scan.hasNextInt()){
          System.out.print("Which sausage would you like to delete? ");
          scan.next();
          deleteNum = true;
        }      
        selectedSausage = scan.nextInt();
        // Validate number range
        if ((selectedSausage > arrayCapacity) || (selectedSausage <=0)){
          System.out.print("Which sausage would you like to delete? ");
          deleteNum = true;
        } else {
          deleteNum = false;
        }
      }
      catch(Exception e){
        System.out.print("Which sausage would you like to delete? ");
        scan.next();
        deleteNum = true;
      }      
    } while (deleteNum);
    
    fullPackBox.DeleteSausage(selectedSausage);
    //arrayCapacity--;
  }
}
