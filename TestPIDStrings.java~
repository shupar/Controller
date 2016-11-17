import java.util.*;

public class TestPIDStrings
{
  public static void main (String[]args)
  {    
    Scanner reader=new Scanner(System.in);
    System.out.println("Plz enter the controller type");
    String controller=reader.next();
    
    while(!controller.equals("P")&&!controller.equals("I")&&!controller.equals("D")&&!controller.equals("PI")&&!controller.equals("PD")&&!controller.equals("ID")&&!controller.equals("PID"))
    {
      System.out.println("You did not enter a valid type of controller. Please try again.");
      controller=reader.next();      
    }
    
    System.out.println("Controller type is: "+controller);
      
    reader.close();
  }//end main
  
}//end class
