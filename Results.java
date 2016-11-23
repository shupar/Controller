import java.io.*;

public class Results 
{
  public void calculations(double setPointChange, double disturbanceChange, double tDistStart, double tDistEnd, Proportional proportional, Integral integral, Derivative derivative,
                             Processes process, double tChangeSP, int iterations, double delx, double tauv, double kv, String choice, int systemSelection)
  {
    int size=iterations+2;
    double [] time=new double [size];
    double [] response=new double [size];
    double [] error=new double [size];
    double [] propError=new double [size];
    double [] intError=new double [size];
    double [] derError=new double [size];
    double [] signal=new double [size];
    double [] setPoint=new double [size];
    double [] fceOut=new double [size];
    double tempDisturbance = 0;
    
    time[0]=-delx;
    response[0]=0;
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
        setPoint[i]=tChangeSP;  
          
      time[i]=time[i-1]+delx;
      error[i]=response[i-1]-setPoint[i];
      propError[i]=proportional.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      intError[i]=integral.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      derError[i]=derivative.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      signal[i]=1+(propError[i]+intError[i]+derError[i]);
      
      if (tauv==0)
        fceOut[i]=kv*signal[i];
      else 
         fceOut[i]=fceOut[i-1]+delx*(kv*signal[i]-fceOut[i-1])/tauv;
     
      
      if (error[i]==0)
        response[i]=response[0];//verify this!!
      else 
        response[i]=process.calculateReponseOfProcess(time[i], response[i-1], delx, fceOut[i], disturbanceChange, choice, tDistStart); //////////////////
                                    //public double calculateReponseOfProcess(double t1, double response, double delx, double fceOUT, double disturbance, 
                                                                                                                           
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
      outputStream.println("t [s]\tT(t) [K]");
    }
    else if(systemSelection==2)
    {
      outputStream.println("t [s]\tH(t) [m]");
    }
    
    for (int i=0; i<response.length; i++)
    {
      outputStream.println(time[i]+"\t"+response[i]);
    }
    
    outputStream.close();   
  }

}//end of class