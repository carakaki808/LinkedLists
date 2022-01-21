/**
 * CNode --- this is the node class for the Computer list.
 * @author Cameron Arakaki
 */
public class CNode {
   private Computer comp = null;
   private CNode next = null;
   
   // constructors
   public CNode(){
      this.comp = comp;
      this.next = next;
   }
   
   public CNode(Computer c){
      this.setComputer(c);
      this.next = null;
   }
   
   
   // allows the use of compareTo in list class from computer class
   public int compareTo(Object o) {
      CNode n = (CNode)o;
      Computer c1 = this.getComputer();
      Computer c2 = n.getComputer();
      return (c1.compareTo(c2));         
   }
   
   // set/get next node reference
   public void setNext(CNode n){
      this.next = n;
   }
   
   public CNode getNext(){
      return this.next;
   }
   
   // validate computer object
   public void setComputer(Computer c){
      this.comp = c;
   }
   
   public Computer getComputer(){
      return this.comp;
   }
   
   // toString method to print Computer object
   public String toString(){
      String s = this.getComputer().toString();
      
      return s;
   }
}