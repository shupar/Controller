import java.util.*;

public class TestModulusFct
{
  public static void main(String[]args)
  {
    Scanner reader=new Scanner(System.in);
    int timeInc=5;
    int runTime=100;
    int startSetPoint=0;
    
    System.out.println("Please enter your start of set point time");
    startSetPoint=reader.nextInt();
    
    while (startSetPoint%timeInc!=0)
    {
      System.out.println("Your set point time is not a multiple of you time increment. Plz try again.");
      startSetPoint=reader.nextInt();      
    }
    
  }//end main
  
}//end class