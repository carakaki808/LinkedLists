/**
 * Computer --- program to set computer properties
 * @author Cameron Arakaki
 */
import java.text.*;
public class Computer implements Comparable {

   private int barcode;
   private int os;
   private double price;
   private String model;
   
   // Constructor
   public Computer (int barcode, int os, double price, String model) throws Exception {
      this.setBarcode(barcode);
      this.setOs(os);
      this.setPrice(price);
      this.setModel(model);
   }

   // list sort
   public int compareTo(Object c) {
      Computer b = (Computer) c;
      if (this.getBarcode() < b.getBarcode()) {
         return -1;
      }
      if (this.getBarcode() > b.getBarcode()) {
         return 1;
      }
      return 0;
   } 
   
   // Set barcode & validate input
   public void setBarcode(int barcode) throws Exception {
      if ((barcode >= 10001) && (barcode <= 99999)) {
         this.barcode = barcode;
      }
      else {
         ComputerException compEx = new ComputerException();
         compEx.setMessage("Barcode must be within range of 10001 & 99999.");
         throw compEx;
      }
   }
   
   // Set os & validate input
   public void setOs(int os) throws Exception {
      if ((os >= 1) && (os <= 3)) {
         this.os = os;
      }
      else {
         ComputerException compEx = new ComputerException();
         compEx.setMessage("OS must be within range of 1 & 3.");
         throw compEx;
      }
   }
   
   // Set Price & validate input
   public void setPrice (double price) throws Exception {
      if ((price >= 50.00) && (price <= 19999.00)) {
         this.price = price;
      }
      else {
         ComputerException compEx = new ComputerException();
         compEx.setMessage("Price must be within range of 50.00 & 19999.00.");
         throw compEx;
      }
   }
   
   // Set model & validate input
   public void setModel (String model) throws Exception {
      String tModel = model.trim(); // Trims whitespace from string model
      
      if (tModel.length() >= 2) {
         this.model = tModel;
      }
      else {
         ComputerException compEx = new ComputerException();
         compEx.setMessage("Model must have at least 2 non-blank characters.");
         throw compEx;
      }
   }
   
   // Get barcode
   public int getBarcode() {
      return this.barcode;
   }
   
   // Get os
   public int getOs() {
      return this.os;
   }   
   
   // Get price
   public double getPrice() {
      return this.price;
   }
   
   // Get model
   public String getModel() {
      return this.model;
   }
   
   // Returns a String of computer details
   public String toString() {
      String compDets = "";
      String os1 = ""; // Assigned OS to be printed
      
      if (this.os == 1) {
         os1 = "Windows";
      } 
      else if (this.os == 2) {
         os1 = "MacOS";
      } 
      else if (this.os == 3) {
         os1 = "Linux";
      }
      
      DecimalFormat df2 = new DecimalFormat("00.00"); // Output two decimal places for price
      
      double num = this.price;
      
      compDets = ("Barcode: " + this.barcode + "\n" +
           "Operating System: " + os1 + "\n" +
           "Price: $" + df2.format(num) + "\n" +
           "Model: " + this.model + "\n");
           
      return compDets;
   }
}