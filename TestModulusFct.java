import java.util.*;

public class TestModulusFct
{
  public static void main(String[]args)
  {
    Scanner reader=new Scanner(System.in);
    double timeInc=0.05;
    double runTime=100;
    double startSetPoint=0;
    
    System.out.println("Please enter your start of set point time");
    startSetPoint=reader.nextDouble();

    double x = startSetPoint / timeInc;
    int xint;
    xint=(int)x;
    double result = startSetPoint - timeInc * xint;
    
    while (result!=0)
    {
      System.out.println("Your set point time is not a multiple of you time increment. Plz try again.");
      startSetPoint=reader.nextDouble();      
    }
    
  }//end main
  
}//end class