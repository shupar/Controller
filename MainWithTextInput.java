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
      double iterations=0;
      int choice=0;
      iterations=runTime/timeInc;
      
      System.out.println("For your set run time and time increment for iterations, the program will compute "+iterations+".");
      System.out.println("Please enter 1 into the java compile if you would like to proceed or 2 if you would like to reevaluate the amount of iterations to simulate.");
     
      //MAKE THIS A TRY/CATCH
      /*while(!reader.hasNextInt())
      {
        System.out.println("You did not enter either 1 or 2 (as an integer) for your choice of how to proceed. Plz try again.");
      }*/ 
      choice=reader.nextInt();
      
      while(choice!=1&&choice!=2)
      {
        System.out.println("You did not enter either 1 or 2 (as an integer) for your choice of how to proceed. Plz try again.");
       
      //MAKE THIS A TRY/CATCH
      /*while(!reader.hasNextInt())
      {
        System.out.println("You did not enter either 1 or 2 (as an integer) for your choice of how to proceed. Plz try again.");
      }*/ 
        choice=reader.nextInt();
      } 
      
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
   
    
    inputStream.close();
    
  }//end main
  
}//end text input class