/**
 * ComputerListStore --- Create Computer objects from user-defined data, 
 * then store those objects within a linkedList
 * Manage list of objects, and print them to the console.
 * @author Cameron Arakaki
 */
import java.util.*;
public class ComputerListStore {
   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner(System.in);
      boolean exit = false;
      SList newList = new SList();
      
      while (exit != true){
         scan = new Scanner(System.in);            
         int choice = 0;
         int barcode = 0;
         int os = 0;
         double price = 0;
         String model = null;
         boolean foundDupe = false;
         boolean removed = false;
      
         try {
            // menu prompt
            System.out.println("\n1. Add a computer.\n" +
                               "2. Remove a computer.\n" +
                               "3. Find computer based on barcode and print it\n" +
                               "4. Print all the computers.\n" +
                               "0. End this program.");
                         
            choice = scan.nextInt();
            
            switch (choice) {
            
               // add a computer object to a linked list in order of barcode
               case 1:
                  System.out.println("You've selected option 1.\n" +
                                     "Enter barcode (Range from 10001 to 99999. Duplicates are invalid):");                 
                  barcode = scan.nextInt();
                  foundDupe = newList.checkDupe(barcode);
                  
                  if (foundDupe != true) {                                      
                     System.out.println("Enter OS (1 = Windows, 2 = MacOS, 3 = Linux):");                  
                     os = scan.nextInt(); 
                                                  
                     System.out.println("Enter price (range from 50.00 & 19999.00):");                  
                     price = scan.nextDouble();
                                                     
                     System.out.println("Model (enter a string):");                  
                     model = scan.next();                  
                        
                     Computer newComputer = new Computer(barcode, os, price, model);
                        
                     newList.add(newComputer);
                  }
                  else {
                     System.out.println("Duplicate found!");
                  }             
                  break;
                  
               case 2:
                  System.out.println("You've selected option 2. Please enter a barcode:");
                  barcode = scan.nextInt();
                  removed = newList.remove(barcode);
                  if (removed == true) {
                     System.out.println("Computer has been removed!\n");
                  }
                  break;
                  
               case 3:
                  System.out.println("You've selected option 3. Please enter a barcode:");
                  barcode = scan.nextInt();
                  if (newList.find(barcode) != null) {
                     System.out.println("Barcode found!\n");
                     System.out.println(newList.find(barcode));
                  }
                  else {
                     System.out.println("No barcode found!\n");
                  }
                  break;
               case 4:
                  newList.printList();
                  break;
               case 0:
                  System.out.println("Thank You!");
                  exit = true;
                  break;
               default:
                  System.out.println("Must enter a number between 0 and 4.\n");
                  break;               
            }
         }
         // Exceptions handler           
         catch (ComputerException ce) {
            System.out.println(ce.getMessage()); 
         }
         catch (InputMismatchException ime) {
            System.out.println("Incorrect input. Try again!\n");
         }
      }   
   }
}