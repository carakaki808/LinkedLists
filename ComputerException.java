/**
 * ComputerExceptions --- Exceptions handling for Computer.java
 * @author Cameron Arakaki
 */
public class ComputerException extends Exception{

   private String message;
   
   public ComputerException() {
   }
   
   public void setMessage(String message) {
      this.message = message;
   }
   
   public String getMessage() {
      return this.message;
   }
}