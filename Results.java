//this is the class that connects everything together to then ouput a response vs. time
import java.io.*;

public class Results 
{
  //method inputs parameters from the main that are necessary to cary out the ODE solver and the control loop
  public void calculations(double setPointChange, double disturbanceChange, double tDistStart, double tDistEnd, Proportional proportional, Integral integral, Derivative derivative,
                             Processes process, double tChangeSP, int iterations, double delx, double tauv, double kv, int systemSelection)
  {
    //size the whole code works in a huge for loop, create arrays of length run time (plus one block for the time=-timeInc) store all method outputs in an array
    int size=iterations+2;
    double [] time=new double [size];
    double [] responseDisturbance=new double [size];
    double [] responseManipulated=new double [size];
    double [] responseFinal=new double [size];
    double [] error=new double [size];
    double [] propError=new double [size];
    double [] intError=new double [size];
    double [] derError=new double [size];
    double [] signal=new double [size];
    double [] setPoint=new double [size];
    double [] fceOut=new double [size];
    
    //the first space in each array is set manually
    time[0]=-delx;
    responseDisturbance[0]= process.intialiseDisturbanceArray();
    responseManipulated[0]=0;
    responseFinal[0]= process.intialiseControlledVariable(); 
    error[0]=0;
    propError[0]=0;
    intError[0]=0;
    derError[0]=0;
    signal[0]=1;
    setPoint[0] = process.intialiseControlledVariable();
    
    int iStart = (int)(tDistStart/delx +1);
    int iEnd = (int)(tDistEnd/delx +1);
    
    if (tauv==0)
      fceOut[0]=kv*signal[0];
    else 
      fceOut[0]=kv*signal[0]/tauv;
      
    for(int i=1; i<size; i++)
    {
      time[i] = time[i-1] + delx;
      
       if (time[i] < tChangeSP)
      {
        setPoint[i]=setPoint[0]; //before set point change

      }
      else if(tChangeSP == 0 && disturbanceChange != 0)
      {
        setPoint[i] = responseFinal[0];

      } //if its a disturbance
      else if(time[i] >= tChangeSP)
      {
        setPoint[i]=setPointChange;

      }

      
      error[i]=setPoint[i]-responseFinal[i-1];
      propError[i]=proportional.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      intError[i]=intError[i-1]+integral.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      derError[i]=derivative.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      signal[i]=1+(propError[i]+intError[i]+derError[i]);
      
      if (tauv==0)
        fceOut[i]=kv*signal[i];
      else 
         fceOut[i]=fceOut[i-1]+delx*(kv*signal[i]-fceOut[i-1])/tauv;
     
      
     
      
      if(i == iStart && disturbanceChange != 0) //only hit during disturbance simulation
       {
         process.turnOnDisturbance(disturbanceChange);
      
       }
       else if (i == iEnd  && disturbanceChange != 0) //will only hit during disturbance simulation
       {
         process.turnOffDisturbance(disturbanceChange);
     
       } 
      

      if ((tDistStart<=0)&&(error[i]==0) && setPointChange == 0)
      {
        responseDisturbance[i]=responseDisturbance[0]; //gives a zero disturbance at less  0 times
       
      }
             
      if (time[i]<tDistStart||time[i]>tDistEnd) //outside of disturbance bounds
       {
         double disturbance=0;
         //System.out.println("Outside of disturbance " +time[i]);
         responseDisturbance[i]=process.calculateReponseOfProcessDisturbance(time[i], responseDisturbance[i-1], delx, fceOut[i], disturbance);
       }
       else
       {
        responseDisturbance[i]=process.calculateReponseOfProcessDisturbance(time[i], responseDisturbance[i-1], delx, fceOut[i], disturbanceChange);        
        //System.out.println("last else");
       }
        responseManipulated[i]=process.calculateReponseOfProcessManipulated(time[i], responseManipulated[i-1], delx, fceOut[i], disturbanceChange);
        if (error[i]==0)
          responseFinal[i]=responseFinal[0];//verify this!!
        else 
          responseFinal[i]=  responseDisturbance[i]+responseManipulated[i];
       //System.out.println("i is "+ i+ "distChange is: " + disturbanceChange); 
    }
  
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
      outputStream.println("t [s]\tSet point\t Error \t intError \tderError \tsignal \tDisturbance \tManipulated \t Tout (K)");
    }
    else if(systemSelection==2)
    {
      outputStream.println("t [s]\tSet point\t Error \t intError \tderError \tsignal \tDisturbance \tManipulated \t Tout (K)");
    }
    
    for (int i=0; i<responseFinal.length; i++)
    {
      outputStream.println(time[i]+"\t"+setPoint[i]+"\t"+error[i]+"\t"+intError[i]+"\t"+derError[i]+"\t"+signal[i]+"\t"+responseDisturbance[i]+"\t"+responseManipulated[i]+"\t"+responseFinal[i]);
    }
    
    outputStream.close();   
  }

}//end of class