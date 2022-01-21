/**
 * SList --- linked list class for ComputerStore driver, implements methods used for list  
 * @author Cameron Arakaki
 */
public class SList {
   private static int count = 0;
   private CNode first = null;
   private CNode last = null;
   private CNode cursor = null;
   private CNode preCursor = null;
      
   // constructor
   public SList() {         
   }
   
   public boolean checkDupe(int barcode) {
      int i = 0;
      cursor = first;
      for (i = 0; i < count; i++) {
         if (cursor.getComputer().getBarcode() == barcode) {
            return true;
         }
         else {
            cursor.setNext(cursor.getNext());
         }
      }
      return false;
   }
      
   // add reference, computer object, to list sorted by barcode
   public void add(Computer c) {
      CNode n = new CNode(c);
      cursor = first;
      preCursor = cursor;
      int i = 0;
   
      if (count == 0) {         
         first = n;
         last = n;
         count++;            
      }
      else { // add element in order of barcode            
         if (n.compareTo(last) > 0) {
            last.setNext(n);
            last = n;
            count++;               
            return;
         }
         if (n.compareTo(first) < 0) {
            n.setNext(first);
            first = n;
            count++;
            return;
         }
         cursor = first.getNext();
         preCursor = first;
         for (i = 0; i < count; i++){
            if (n.compareTo(cursor) < 0) {
               preCursor.setNext(n);
               n.setNext(cursor);
               count++;
               return;                  
            }
            else {
               cursor = cursor.getNext();
               preCursor = preCursor.getNext();
            }                           
         }
      }
      last.setNext(n);
      last = n;
   }
   
   // return size of list
   public int size() {
      return count;
   }
   
   // initiate removal of element
   public boolean remove(int barcode) {
      cursor = first;
      preCursor = cursor;
      
      while (cursor != null) {
         if (cursor.getComputer().getBarcode() == barcode) {
            if (first.getComputer().getBarcode() == barcode) {
               first = first.getNext();
               cursor.setNext(null);
               count--;
               if (count < 0) {
                  count = 0;
               }
               return true;
            }
            else {
               preCursor.setNext(cursor.getNext());
               cursor.setNext(null);
               count--;
               if (count < 0) {
                  count = 0;
               }
               return true;
            }
         }
         else {
            cursor = cursor.getNext();
         }
      }
      System.out.println("No barcode found!\n");
      return false;
   }
   
   // find computer with matching barcode
   public Computer find(int barcode) {
      cursor = first;
      
      while (cursor != null) {
         if (cursor.getComputer().getBarcode() != barcode) {
            cursor = cursor.getNext();
         }
         else {
            return cursor.getComputer();
         }
      }
      return null;
   }
   
   // print nodes in list
   public void printList() {
      cursor = first;
      int i = 0;
      if (cursor == null) {
         System.out.println("List is empty!");
      }
      else {
         for (i = 0; i < count; i++) {
            System.out.println(cursor.toString());
            cursor = cursor.getNext();
         }
      }
   }
}