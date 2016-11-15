import java.util.*;
import java.io.*;

public class MainWithTextInput
{
  public static void main (String[] args)
  {
    Scanner inputStream=null;
   
    try
    {
      inputStream=new Scanner(new FileInputStream("UserInput.txt"));
    }//end try
    
    catch (FileNotFoundException e)
    {
      System.out.println("There was an error accessing the UserInput.txt file! Please check that it does in fact exist and it is not open a the moment.");
      System.exit(0);
    }//end catch
    
    //Scanning for process to simulate
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for system selection. Plz modify the text file and try again.");
      inputStream.close();
      return;
    }
    int systemSelection=inputStream.nextInt();
    
    if (systemSelection==1)
    {
      
    }//add code for CSTR heating
    else if(systemSelection==2)
    {
      
    }//add code for level system
    else 
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the process you would like to simulate.");
      inputStream.close();
      return;
    }
    inputStream.nextLine();
    
   //System.out.println("systemSelection is: "+systemSelection);;
    
    //scanning for type of input signal to impose on selected process
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for input signal. Plz modify the text file and try again.");
      inputStream.close();
      return;
    }
    int inputSignal=inputStream.nextInt();
    inputStream.nextLine();
        
    double stepChange=0;
    double disturbanceMag=0;
    double disturbanceStart=0;
    double disturbanceEnd=0;
    
    //if user choses a step change, scan for step
    if (inputSignal==1)
    {
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an interger or double type value for your desired step. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
      stepChange=inputStream.nextDouble();
    }
    
    //if user selects disturbance, scan for dusturbance magnitude and time 
    else if (inputSignal==2)
    {
      inputStream.nextLine();
      
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double type value for your disturbance magnitude. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
      disturbanceMag=inputStream.nextDouble();
      
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for the start time of your disturbance. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
      disturbanceStart=inputStream.nextDouble();
      
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for the end time of your disturbance. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
      disturbanceEnd=inputStream.nextDouble();
    }
    //if user enters an int but not one of the choices
    else
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the type of change (input signal) you would like to invoke on your process.");
      inputStream.close();
      return;
    }
    
    if (disturbanceStart>disturbanceEnd)
    {
     System.out.println("Your disturbance start time must come before your disturbance end time!! Plz modify the text file and try again."); 
     inputStream.close();
     return;
    }
    
    System.out.println("inputSignal is: "+inputSignal);
    System.out.println("stepChange is: "+stepChange);
    System.out.println("Disturbance magnitude is: "+disturbanceMag+" \nDisturbance start time is: "+disturbanceStart+"\nDisturbance end is: "+disturbanceEnd);
    
    
    //input time increment and runtime
    inputStream.nextLine();
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for the time increment. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
    double timeInc=inputStream.nextDouble();
      
    inputStream.nextLine();
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for the run time of your simulation. Plz modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
    double runTime=inputStream.nextDouble();
    
    if(timeInc>=runTime)
    {
      System.out.println("Your time increment is larger or equal that your simulation runtime. You should reconsider how often you would like to iterate.");
      inputStream.close();
      return;
    }
    else 
    {
      Scanner reader=new Scanner(System.in);
      boolean exit=false;
      double iterations=0;
      int choice=0;
      iterations=runTime/timeInc;
      
      System.out.println("For your set run time and time increment for iterations, the program will compute "+iterations+".");
     
      do
    {
      exit=false;
      while(!exit)
      {
        try
        {
          System.out.println("Please enter 1 into the java compile if you would like to proceed or 2 if you would like to reevaluate the amount of iterations to simulate.");
          choice=reader.nextInt();
          exit=true;
        }
        
        catch(InputMismatchException e)
        {
          reader.nextLine();
          System.out.println("You did not select option 1 or 2 (entered as an integer). Please enter 1 to proceed with the rest of the code or 2 to reevaluate the number of iterations.");
        }
      }
    }while(choice!=1&&choice!=2);
    //end catch for user's selection of how to proceed
           
      if(choice==2)
      {
        reader.close();
        System.out.println("Proceed to the text file to change your time specifications then come back to compile and run once more.");
        inputStream.close();
        return;
      }
      else
      {
        reader.close();
      }
    }
   
    //code to read process setpoint and tolerance
    inputStream.nextLine();
    double setPoint=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for your desired setpoint. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
    setPoint=inputStream.nextDouble();
    System.out.println("The setpoint is: "+setPoint);
    
    inputStream.nextLine();
    double tol=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for your desired tolerance. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
    tol=inputStream.nextDouble();
    System.out.println("The tolerance is: "+tol);
    
    //code to read valve details
    inputStream.nextLine();
    double kV=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for the gain of the valve you are using. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
    kV=inputStream.nextDouble();
    System.out.println("The gain of the valve is: "+kV);
    
    inputStream.nextLine();
    double tauV=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for the time constant of your valve. Plz modify the text file and try again.");
      inputStream.close();
      return;
      }
    tauV=inputStream.nextDouble();
    System.out.println("The time constant of your valve is: "+tauV);

    //code to read what type of controller to simulate
    inputStream.nextLine();
    String controller=inputStream.next();
    //System.out.println("The controller type you have chosen is: "+controller);
    
    while(!controller.equals("P")&&!controller.equals("I")&&!controller.equals("D")&&!controller.equals("PI")&&!controller.equals("PD")&&!controller.equals("ID")&&!controller.equals("PID"))
    {
      System.out.println("You did enter a valid type of controller. Please go back into the text file and modify your choice.");
      inputStream.close();
      return;      
    }
    
      //what to do next as a function of user controller choice
    double kC=0;
    double tauI=1000000000;//large number to cancel out term
    double tauD=0;
    
    if (controller.equals("P"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        //CALL RESULTS  
      }
      else if(controller.equals("I"))
      {
        inputStream.nextLine();
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
        //CALL RESULTS  
      }
      else if(controller.equals("D"))
      {
        inputStream.nextLine();
        inputStream.nextLine();
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
        //CALL RESULTS  
      }
      else if(controller.equals("PI"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
        //CALL RESULTS  
      }
      else if(controller.equals("PD"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);

       //CALL RESULTS  
      }
      else if(controller.equals("ID"))
      {
        inputStream.nextLine();
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI); 
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
        //CALL RESULTS
        
      }
      else if(controller.equals("PID"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Plz modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
        //CALL RESULTS
      }
      
      //create object P, I and D and send the approporiate instance variables 
      //create either CSTR or level object depending on user
      
     /* double[] results=calculate value,fbvxkbjkv
        
        for (i=0; i<runTime; i++)
      {
        (print results(i) vs i)//qui correspond à f(t) vs t
        
      }*/
   
    inputStream.close();
    
  }//end main
  
}//end text input class