import java.util.*;

public class PIDInput3
  
{
  public static void main (String[] args)
     
    
  { 
    
    Scanner reader=new Scanner(System.in);//won't be used for the actual code as all the inputs will be in a text file
    
    String controlleroption;
    double propSignal, intSignal, derivSignal;
    double kC, tauI, tauD;
   
    
    System.out.println("Would you like the controller to be Proportional? If so type \"yes\", otherwise type \"no\".");
    controlleroption=reader.nextLine(); 
    while(controlleroption != "no" && controlleroption != "yes")
    {
      System.out.println("Sorry try again. Type \"yes\" if you want the controller to be proportional. Otherwise type \"no\".");
     controlleroption=reader.nextLine(); 
    }
    
    if (controlleroption.equalsIgnoreCase("yes")) //receives proportional response
    {
      /*System.out.println("Enter the value of Kc");
      kC=reader.nextDouble();
      Proportional prop=new Proportional(kC);
      propSignal=prop.calculateSignal;*/
      propSignal=1;
      
    }
    else if(controlleroption.equalsIgnoreCase("no"))
      propSignal=0;
            
    System.out.println("Would you like the controller to be Derivative? If so type \"yes\", otherwise type \"no\".");
    controlleroption=reader.nextLine(); 
    while(controlleroption != "no" && controlleroption != "yes")
    {
      System.out.println("Sorry try again. Type \"yes\" if you want the controller to be integral. Otherwise type \"no\".");
      controlleroption=reader.nextLine(); 
    }
    
    if (controlleroption.equalsIgnoreCase("yes")) //receives integral response
    {
      /*System.out.println("Enter the value of TauI");
      tauI=reader.nextDouble();
      Integral integ=new Integral(kC, tauI);
      intSignal=integ.calculateSignal;*/
      intSignal=2;
    }
     else if(controlleroption.equalsIgnoreCase("no"))
      intSignal=0;
     
    System.out.println("Would you like the controller to be Derivative? If so type \"yes\", otherwise type \"no\".");
    controlleroption=reader.nextLine(); 
            
    while(controlleroption != "no" && controlleroption != "yes")
    {
      System.out.println("Sorry try again. Type \"yes\" if you want the controller to be derivative. Otherwise type \"no\".");
      controlleroption=reader.nextLine(); 
    }
    
    if (controlleroption.equalsIgnoreCase("yes")) //receives derivative response
    {
      /*System.out.println("Enter the value of TauD");
      tauD=reader.nextDouble();
      Derivative deriv=new Derivative(kC, tauD);
      derivSignal=deriv.calculateSignal;*/
      derivSignal=3;
      
    }  
    else if(controlleroption.equalsIgnoreCase("no"))
      derivSignal=0;  
   
    
    double finalSignal=propSignal+intSignal+derivSignal; //help with this part 
            
    System.out.println(finalSignal);

    reader.close();

        
  }
  
}


                         
//code to scan excel sheet
    