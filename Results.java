import java.io.*;

public class Results 
{
  public void calculations(double setPointChange, double disturbanceChange, double tDistStart, double tDistEnd, Proportional proportional, Integral integral, Derivative derivative,
                             Processes process, double tChangeSP, int iterations, double delx, double tauv, double kv, int systemSelection)
  {
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
    double tempDisturbance = 0;
    
    time[0]=-delx;
    responseDisturbance[0]=0;
    responseManipulated[0]=0;
    responseFinal[0]=0;
    error[0]=0;
    propError[0]=0;
    intError[0]=0;
    derError[0]=0;
    signal[0]=1;
    setPoint[0]=0;
    
    if (tauv==0)
      fceOut[0]=kv*signal[0];
    else 
      fceOut[0]=kv*signal[0]/tauv;
      
    for(int i=1; i<size; i++)
    {
      if (time[i]<tChangeSP)
        setPoint[i]=setPoint[0];
      else 
        setPoint[i]=setPointChange;  
          
      time[i]=time[i-1]+delx;
      error[i]=setPoint[i]-responseFinal[i-1];
      propError[i]=proportional.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      intError[i]=intError[i-1]+integral.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      derError[i]=derivative.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      signal[i]=1+(propError[i]+intError[i]+derError[i]);
      
      if (tauv==0)
        fceOut[i]=kv*signal[i];
      else 
         fceOut[i]=fceOut[i-1]+delx*(kv*signal[i]-fceOut[i-1])/tauv;
     
      
      if (error[i]==0)
        responseFinal[i]=responseFinal[0];//verify this!!
      
  //Le probleme ici c'est que le disturbance part de 0 genre
      if ((tDistStart<=0)&&(error[i]==0))
        responseDisturbance[i]=responseDisturbance[0];
       else if (time[i]<tDistStart||time[i]>tDistEnd)
       {
         double disturbance=0;
         responseDisturbance[i]=process.calculateReponseOfProcessDisturbance(time[i], responseDisturbance[i-1], delx, fceOut[i], disturbance);
       }
       else
          responseDisturbance[i]=process.calculateReponseOfProcessDisturbance(time[i], responseDisturbance[i-1], delx, fceOut[i], disturbanceChange);
          
          responseManipulated[i]=process.calculateReponseOfProcessManipulated(time[i], responseManipulated[i-1], delx, fceOut[i], disturbanceChange);
          
          responseFinal[i]=responseDisturbance[i]+responseManipulated[i];
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
      outputStream.println("t [s]\tSet point\t Error \t intError \tderError \tsignal \t Tout (K)");
    }
    else if(systemSelection==2)
    {
      outputStream.println("t [s]\tH(t) [m]");
    }
    
    for (int i=0; i<responseFinal.length; i++)
    {
      outputStream.println(time[i]+"\t"+setPoint[i]+"\t"+error[i]+"\t"+intError[i]+"\t"+derError[i]+"\t"+signal[i]+"\t"+responseFinal[i]);
    }
    
    outputStream.close();   
  }

}//end of class