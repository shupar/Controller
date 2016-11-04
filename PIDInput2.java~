import java.util.*;

public class PIDInput2
  
{
  public static void main (String[] args)
     
    
  { 
    double propSignal, intSignal, derivSignal;
   
    Scanner keyboard=new Scanner(System.in);
    
    int controlleroption;
    double kC, tauI, tauD;
   
    
    //Excel sheet pops up and dispalys://
    System.out.println("Would you like the controller to be Proportional? If so type 1, otherwise type 0");
    controlleroption=keyboard.nextInt();
    while(controlleroption != 0 && controlleroption != 1)
    {System.out.println("Sorry try again. Type 1 if you want the controller to be proportional. Otherwise 0.");
     controlleroption=keyboard.nextInt(); 
    }
    
    if (controlleroption==0)
    propSignal=0;
    
    //user inputs a number in excel, for loop in case they don't answer 1 or 0//
    System.out.println("Would you like the controller to be Integral? If so type 2, otherwise type 0");
    controlleroption=keyboard.nextInt();
     while(controlleroption != 0 && controlleroption != 2)
    {System.out.println("Sorry try again. Type 2 if you want the controller to be proportional. Otherwise 0.");
     controlleroption=keyboard.nextInt();
    }
   
    if (controlleroption==0)
    intSignal=0;
   
    
    //user inputs a number in excel, for loop in case they don't answer 2 or 0//
    System.out.println("Would you like the controller to be Derivative? If so type 3, otherwise type 0.");
    controlleroption=keyboard.nextInt();
    while(controlleroption != 0  && controlleroption != 3)
    {System.out.println("Sorry try again. Type 3 if you want the controller to be proportional. Otherwise 0.");
     controlleroption=keyboard.nextInt();
    }
    
    if (controlleroption==0)
    derivSignal=0;
    //user inputs a number in excel, for loop in case they don't enter 3 or 0//
    
    
    switch(controlleroption)
    {
      case 1:
       //get kC from text file
        propSignal=1;
       /*Proportional prop=new Proportional(kC);
        propSignal=prop.calculateSignal;*/
       //print into excel file
       break;
      case 2:
       //get kC and tauI from text file
       intSignal=2;
       /*Integral integ=new Integral(kC, tauI);
       intSignal=integ.calculateSignal;*/
       //print out into excel file
       break;
      case 3: 
       //get kC and tauD from text file
       derivSignal=3;
       /*Derivative deriv=new Derivative(kC, tauD);
       derivSignal=deriv.calculateSignal;*/
       //print out into excel file
       break;     
    }//end of switch
    
      
    keyboard.close();
    
    double finalSignal=propSignal+intSignal+derivSignal; //help with this part
  
    

  }
  
}


                         
//code to scan excel sheet
    
    
    