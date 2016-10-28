/**
import java.util.*;

public class Input
{
  public static void main (String[] args)
  {
    Scanner reader = new Scanner(System.in);
    //add: step change, impulse or wave function
    //add: enter process parameters (approximated as 1st order function)
       
    System.out.println("Select the actions the controller can take by inputting the words 'yes' or 'no'.");
    System.out.println("Would you like the controller to be Proportional?");
    String propAction=reader.nextLine();
    System.out.println("Would you like the controller to be Integral?");
    String intAction=reader.nextLine();
    System.out.println("Would you like the controller to be Derivative?");
    String derivAction=reader.nextLine();
    //add: loop if not the right choice
    //add: display selection of user
    
    double kC, tauI, tauD;
    double propSignal, intSignal, derivSignal;
    
    if (propAction.equalsIgnoreCase("yes")) //receives proportional response
    {
      System.out.println("Enter the value of Kc");
      kC=reader.nextDouble();
      Proportional prop=new Proportional(kC);
      propSignal=prop.calculateSignal;
    }
    
    if (intAction.equalsIgnoreCase("yes")) //receives integral response
    {
      System.out.println("Enter the value of TauI");
      tauI=reader.nextDouble();
      Integral integ=new Integral(kC, tauI);
      intSignal=integ.calculateSignal;
    }
    
    if (derivAction.equalsIgnoreCase("yes")) //receives derivative response
    {
      System.out.println("Enter the value of TauD");
      tauD=reader.nextDouble();
      Derivative deriv=new Derivative(kC, tauD);
      derivSignal=deriv.calculateSignal;
    }  
    
    double finalSignal=propSignal+intSignal+derivSignal;
    
    reader.close();
    
  } //End of main method  
  
} // End of class
**/