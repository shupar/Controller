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
      System.out.println("There was an error accessing the UserInput.txt file! Please check that it does in fact exist and it is not open at the moment.");
      System.exit(0);
    }//end catch
    
    //Scanning for process to simulate
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for system selection. Please modify the text file and try again.");
      inputStream.close();
      return;
    }
    int systemSelection=inputStream.nextInt();
        
    if (systemSelection==1)
    {
      System.out.println("The system you have selected is the CSTR heating system.");
    }
    else if(systemSelection==2)
    {
      System.out.println("The system you have selected is the level control system.");
    }
    else 
    {
      System.out.println("Please enter either 1 or 2 into the text file depending on the process you would like to simulate.");
      inputStream.close();
      return;
    }
  
    //scanning for type of input signal to impose on selected process
   inputStream.nextLine();
    while(!inputStream.hasNextInt())
    {
      System.out.println("You did not enter an integer that suited the options for input signal. Please modify the text file and try again.");
      inputStream.close();
      return;
    }
    int inputSignal=inputStream.nextInt();
    
    inputStream.nextLine();
        
    double setPoint=0;
    int startSetPoint=0;
    double disturbanceMag=0;
    int disturbanceStart=0;
    int disturbanceEnd=0;
    
    //if user choses a step change, scan for step and start time of step
    if (inputSignal==1)
    {
      System.out.println("You have chosen to invoke a change in setpoint on your selected process.");
      
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or double type value for your desired setpoint. Please modify the text file and try again.");
      inputStream.close();
      return;
      }
      setPoint=inputStream.nextDouble();
      
      inputStream.nextLine();
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an interger type value for your desired step start time. Please modify the text file and try again.");
      inputStream.close();
      return;
      }
      startSetPoint=inputStream.nextInt();
      
      System.out.println("The step change you have chosen is "+setPoint+"and will commence at t = "+startSetPoint+"s.");
      
      //ensure user does not enter a disturbance since they have selected a change in step point
      inputStream.nextLine();
      Boolean pass=false;
      while(!pass)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your disturbance magnitude. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        disturbanceMag=inputStream.nextDouble();
        if (disturbanceMag!=0)
        {
          pass=false;
          System.out.println("You did not input 0 for your disturbance magnitude. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(disturbanceMag==0)
        {
          System.out.println("Your disturbance magnitude value is 0.");
          pass=true;  
        }
      }
      
      inputStream.nextLine();
      Boolean pass1=false;
      while(!pass1)
      {
        while(!inputStream.hasNextInt())
        {
          System.out.println("You did not enter 0 for your disturbance start time. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        disturbanceStart=inputStream.nextInt();
        if (disturbanceStart!=0)
        {
          pass1=false;
          System.out.println("You did not input 0 for your disturbance start time. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(disturbanceStart==0)
        {
          System.out.println("Your disturbance start time is "+disturbanceStart+"s.");
          pass1=true;
        }
      }
      
      inputStream.nextLine();
      Boolean pass2=false;
      while(!pass2)
      {
        while(!inputStream.hasNextInt())
        {
          System.out.println("You did not enter 0 for your disturbance end time. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        disturbanceEnd=inputStream.nextInt();
        if (disturbanceEnd!=0)
        {
          pass2=false;
          System.out.println("You did not input 0 for your disturbance end time. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(disturbanceEnd==0)
        {
          System.out.println("Your disturbance end time is "+disturbanceEnd+"s.");
          pass2=true;
        }
      }
    }
    
   
    //if user selects disturbance, ensure they did not set values for setPoint change
    else if (inputSignal==2)
    {
      System.out.println("You have chosen to invoke a disturbance on your selected process.");
     
      Boolean pass3=false;
      while(!pass3)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your change in set point. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        setPoint=inputStream.nextDouble();
        if (setPoint!=0)
        {
          pass3=false;
          System.out.println("You did not input 0 for your change in set point. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(setPoint==0)
        {
          System.out.println("Your setPoint value is 0.");
          pass3=true;  
        }
      }
      
      inputStream.nextLine();
      Boolean pass4=false;
      while(!pass4)
      {
        while(!inputStream.hasNextInt())
        {
          System.out.println("You did not enter 0 for your change in setpoint start time. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        startSetPoint=inputStream.nextInt();
        if (startSetPoint!=0)
        {
          pass4=false;
          System.out.println("You did not input 0 for your change in setpoint start time. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(startSetPoint==0)
        {
          System.out.println("Your change in setpoint start time is "+startSetPoint+"s.");
          pass4=true;
        }
      }
      
      //input disturbance values
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double type value for your disturbance magnitude. Please modify the text file and try again.");
      inputStream.close();
      return;
      }
      disturbanceMag=inputStream.nextDouble();
      
      inputStream.nextLine();
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an integer type value for the start time of your disturbance. Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
      disturbanceStart=inputStream.nextInt();
      
      inputStream.nextLine();
      while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an integer type value for the end time of your disturbance. Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
      disturbanceEnd=inputStream.nextInt();
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
     System.out.println("Your disturbance start time must come before your disturbance end time!! Please modify the text file and try again."); 
     inputStream.close();
     return;
    }
    System.out.println("The disturbance magnitude you have chosen is "+disturbanceMag+"and will commence at t = "+disturbanceStart+"s and will end at t = "+disturbanceEnd+"s.");
    
    
    //input time increment and runtime
    inputStream.nextLine();
    while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an integer value for the time increment. Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
    int timeInc=inputStream.nextInt();
      
    inputStream.nextLine();
    while(!inputStream.hasNextInt())
      {
      System.out.println("You did not enter an integer type value for the run time of your simulation. Please modify the text file and try again. Note: Ensure your time is in seconds.");
      inputStream.close();
      return;
      }
    int runTime=inputStream.nextInt();
    
    if(timeInc>=runTime)
    {
      System.out.println("Your time increment is larger than or equal to your simulation runtime. You should reconsider how often you would like to iterate.");
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
      
      System.out.println("For your set run time of "+runTime+"s and time increment of "+timeInc+"s for each iteration, the program will compute "+iterations+".");
     
      do
    {
      exit=false;
      while(!exit)
      {
        try
        {
          System.out.println("Please enter 1 into the java compiler if you would like to proceed or 2 if you would like to reevaluate the amount of iterations to simulate.");
          choice=reader.nextInt();
          exit=true;
        }
        
        catch(InputMismatchException e)
        {
          reader.nextLine();
          System.out.println("You did not select option 1 or 2 (entered as an integer).");
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
   
    //code to read tolerance
    inputStream.nextLine();
    double tol=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for your desired tolerance. Please modify the text file and try again.");
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
      System.out.println("You did not enter an integer or a double value for the gain of the valve you are using. Please modify the text file and try again.");
      inputStream.close();
      return;
      }
    kV=inputStream.nextDouble();
    System.out.println("The gain of the valve is: "+kV);
    
    inputStream.nextLine();
    double tauV=0;
    while(!inputStream.hasNextDouble())
      {
      System.out.println("You did not enter an integer or a double value for the time constant of your valve. Please modify the text file and try again.");
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
    
    //for P only type controller
    if (controller.equals("P"))
      {
        inputStream.nextLine();
       while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
       inputStream.nextLine();
      Boolean pass1=false;
      while(!pass1)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your integral time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        if (tauI!=0)
        {
          pass1=false;
          System.out.println("You did not input 0 for your integral time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauI==0)
        {
          tauI=10000000;
          System.out.println("Your integral time constant was set to a very large number of "+tauI+" in order to be able to cancel the integral term.");
          pass1=true;
        }
      }
      
      inputStream.nextLine();
      Boolean pass2=false;
      while(!pass2)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your derivative time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        if (tauD!=0)
        {
          pass2=false;
          System.out.println("You did not input 0 for your derivative time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauD==0)
        {
          System.out.println("Your change in setpoint start time is "+tauD+".");
          pass2=true;
        }
      }
    }
    
     //for I only type controller    
      else if(controller.equals("I"))
      {
        inputStream.nextLine();
      Boolean pass3=false;
      while(!pass3)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 1 for your controller gain. Please modify the text file and try again.");//CHECK!!!!!!!!!!!!!
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        if (kC!=1)
        {
          pass3=false;
          System.out.println("You did not input 1 for your controller gain. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(kC==1)
        {
          System.out.println("Your controller gain is "+kC+".");
          pass3=true;
        }
      }
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
        inputStream.nextLine();
      Boolean pass4=false;
      while(!pass4)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your derivative time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        if (tauD!=0)
        {
          pass4=false;
          System.out.println("You did not input 0 for your derivative time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauD==0)
        {
          System.out.println("Your change in setpoint start time is "+tauD+".");
          pass4=true;
        }
      }  
     }
      
     //for D only type controller
      else if(controller.equals("D"))
      {
         inputStream.nextLine();
      Boolean pass5=false;
      while(!pass5)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 1 for your controller gain. Please modify the text file and try again.");//CHECK!!!!!!!!!!!!!
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        if (kC!=1)
        {
          pass5=false;
          System.out.println("You did not input 1 for your controller gain. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(kC==1)
        {
          System.out.println("Your controller gain is "+kC+".");
          pass5=true;
        }
      }
       
      inputStream.nextLine();
      Boolean pass6=false;
      while(!pass6)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your integral time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        if (tauI!=0)
        {
          pass6=false;
          System.out.println("You did not input 0 for your integral time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauI==0)
        {
          tauI=10000000;
          System.out.println("Your integral time constant was set to a very large number of "+tauI+" in order to be able to cancel the integral term.");
          pass6=true;
        }
      }
        
      inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
      }
      
      //for PI controller type
      else if(controller.equals("PI"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
      inputStream.nextLine();
      Boolean pass7=false;
      while(!pass7)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your derivative time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        if (tauD!=0)
        {
          pass7=false;
          System.out.println("You did not input 0 for your derivative time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauD==0)
        {
          System.out.println("Your change in setpoint start time is "+tauD+".");
          pass7=true;
        }
      } 
    }
      //for PD type controller
      else if(controller.equals("PD"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
      inputStream.nextLine();
      Boolean pass8=false;
      while(!pass8)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for your integral time constant. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        if (tauI!=0)
        {
          pass8=false;
          System.out.println("You did not input 0 for your integral time constant. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(tauI==0)
        {
          tauI=10000000;
          System.out.println("Your integral time constant was set to a very large number of "+tauI+" in order to be able to cancel the integral term.");
          pass8=true;
        }
      }
      
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD); 
      }
      
      //for ID controller type
      else if(controller.equals("ID"))
      {
         inputStream.nextLine();
      Boolean pass9=false;
      while(!pass9)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 1 for your controller gain. Please modify the text file and try again.");//CHECK!!!!!!!!!!!!!
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        if (kC!=1)
        {
          pass9=false;
          System.out.println("You did not input 1 for your controller gain. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(kC==1)
        {
          System.out.println("Your controller gain is "+kC+".");
          pass9=true;
        }
      }      
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI); 
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
        
      }
      else if(controller.equals("PID"))
      {
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the gain of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        kC=inputStream.nextDouble();
        
        System.out.println("The gain of your controller is: "+kC);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the integral time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauI=inputStream.nextDouble();
        
        System.out.println("The integral time constant of your controller is: "+tauI);
        
        inputStream.nextLine();
        
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter an integer or a double value for the derivative time constant of your controller. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        tauD=inputStream.nextDouble();
        
        System.out.println("The derivative time constant of your controller is: "+tauD);
      }
            
      //ARE THERE ANY CONSTRAINTS ON PROCESS INPUT PARAMS?????????????????????????????????????????????
      //CHECK UNITS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     
      //CSTRHeating variable declarations
      double initialT=0;
      double flow=0;
      double cP=0;
      double heat=0;
      double vol=0;
      double rho=0;
      
      //level variable declarations
      double d=0;
      double h=0;
      double initialH=0;
      double flow2=0;
      double cvStar=0;
      double blank=0;//there is only 5 necessary params in the level control therefore we will force user to enter 0 in the last parameter slot
     
     //input process parameters for CSTR heating
     if(systemSelection==1)
     {      
      //T initial [K]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the initial temperature or your process. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      initialT=inputStream.nextDouble();
      System.out.println("The initial temperature of your process is: "+initialT+"K.");
      
      //flow rate [kg/s]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the mass flow rate or your process. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      flow=inputStream.nextDouble();
      System.out.println("The mass flow rate of your process is: "+flow+ "kg/s.");
      
      //heat capacity [kJ/kg*K]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the heat capacity or your process. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      cP=inputStream.nextDouble();
      System.out.println("The heat capacity of your process is: "+cP+"kJ/kg*K.");
      
      //heat input rate [kJ/s]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the heat input rate or your process. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      heat=inputStream.nextDouble();
      System.out.println("The heat input rate of your process is: "+heat+"kJ/s.");
      
      //volume of the tank [m3]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the volume of your process' tank. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      vol=inputStream.nextDouble();
      System.out.println("The volume of your process' tank is: "+vol+"m3.");
      
      //density of the fluid in the system
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the density of your process fluid. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      rho=inputStream.nextDouble();
      System.out.println("The density of your process fluid is: "+rho+"kg/m3.");
     }
     
     //input variables for the level control system
     else if(systemSelection==2)
   {  
      //tank diameter
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for your process' tank diameter. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      d=inputStream.nextDouble();
      System.out.println("The diameter of your tank is: "+d+"m.");
      
      //tank height
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for your process' tank height. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      h=inputStream.nextDouble();
           
      //initial level height
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for your process' initial level height. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      initialH=inputStream.nextDouble();
      
      if (initialH>h)
      {
        System.out.println("Your tank is overflowing!! Go clean up the mess then please modify the text file and try the simulation again."); 
        inputStream.close();
        return;
      }
      System.out.println("The height of your tank is: "+h+"m.");
      System.out.println("The initial height of the fluid in your tank is: "+initialH+"m.");
          
      //volumetric flow rate [m3/s]
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the volumetric flow rate or your process. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      flow2=inputStream.nextDouble();
      System.out.println("The volumetric flow rate of your process is: "+flow2+ "m3/s.");
      
      //Cv star, valve characteristic
      inputStream.nextLine();
      while(!inputStream.hasNextDouble())
      {
        System.out.println("You did not enter an integer or a double value for the Cv* characteristic of your valve. Please modify the text file and try again.");
        inputStream.close();
        return;
      }
      cvStar=inputStream.nextDouble();
      System.out.println("The Cv* valve characteristic is: "+cvStar+".");
      
      inputStream.nextLine();
      Boolean passing=false;
      while(!passing)
      {
        while(!inputStream.hasNextDouble())
        {
          System.out.println("You did not enter 0 for the last parameter in the level system. Please modify the text file and try again.");
          inputStream.close();
          return;
        }
        blank=inputStream.nextDouble();
        if (blank!=0)
        {
          passing=false;
          System.out.println("You did not input 0 for the last parameter in the level system. Please fix the text file and try again.");
          inputStream.close();
          return;
        }
        else if(blank==0)
        {
          passing=true;
        }
      }
     }

      Scanner reader2=new Scanner(System.in);
      boolean exit=false;
      int choice2=0;
      
    do
    {
      exit=false;
      while(!exit)
      {
        try
        {
          System.out.println("All of your text file entries are listed above. If you are ready to proceed with the simulation using the displayed values, enter 1, if not enter 2 to change your input values.");
          choice2=reader2.nextInt();
          exit=true;
        }
        
        catch(InputMismatchException e)
        {
          reader2.nextLine();
          System.out.println("You did not select option 1 or 2 (entered as an integer).");
        }
      }
    }while(choice2!=1&&choice2!=2);
    reader2.close();
    //end catch for user's selection of how to proceed

    //creating controller objects
    Proportional proportional=new Proportional(kC);
    Integral integral=new Integral(kC, tauI);
    Derivative derivative=new Derivative(kC, tauD);
    
    //creating process objects
    CSTRHeatingSystem cstr=new CSTRHeatingSystem(vol, rho, cP, initialT, flow, heat);
    LevelControlSystem level=new LevelControlSystem(d, h, cvStar, initialH, blank, flow2);//dont actually need to send blank cuz dont need to recieve hstar
        
    //call results depending on program
    Results results=new Results();
    
    double[] resultsArray=new double[runTime];
    
     //IS THIS A SECURITY LEAK??????????????????????????????????????????????????????????????????????????????????
    
    if(systemSelection==1)
    {    
      resultsArray=results.calculations(setPoint, disturbanceMag, proportional, integral, derivative, cstr, startSetPoint, runTime, timeInc, tauV, kV);//disturbance start and end and tolerance
    }
    else if (systemSelection==2)
    {
      resultsArray=results.calculations(setPoint, disturbanceMag, proportional, integral, derivative, level, startSetPoint, runTime, timeInc, tauV, kV);//disturbance start and end and tolerance 
    }
    
    System.out.println("Your results will be output into an excel file called FileOutput. Please ensure that when you open the file, you say YES to do I trust where it is coming from and YES to the use of delimiters to separate columns (with the use of tabs) and rows (with the use of the next line function).");
    
    //code for excel file output
    PrintWriter outputStream=null;
    
    try
    {
      outputStream=new PrintWriter (new FileOutputStream("FileOutput.xls"));      
    }//end try
    catch (FileNotFoundException e)
    {
      System.out.println("There was an error opening the output excel file! Please make sure that it is not in use.");
      System.exit(0);      
    }//end catch
    
    //define output columns
    if (systemSelection==1)
    {
      outputStream.println("t [s]\tT(t) [K]\n");
    }
    else if(systemSelection==2)
    {
      outputStream.println("t [s]\tH(t) [m]\n");
    }
    
    for (int i=0; i<resultsArray.length; i++)//start at second 0 or second 1??????????
    {
      outputStream.println(i+"\t"+resultsArray[i]+"\n");      
    }
    
    outputStream.close();
    inputStream.close();
    
  }//end main
  
}//end text input class