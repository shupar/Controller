public class Results 
{
  /*Proportional proportional;
  Integral integral;
  Derivative derivative;
  //Obecjt disturbance
<<<<<<< HEAD
 ¨Process cstrHeatingSystem;//for the moment just for this process without disturbance*/
 //Emily can you see my changes?
 Process cstrHeatingSystem;//for the moment just for this process without disturbance*/
  
  public double[] calculations(double setPointChange, double disturbanceChange, Proportional proportional, Integral integral, Derivative derivative,
                             Processes process, int tChangeSP, int timeOfSimulation, int delx, double tauv, double kv)
  {
    
   // array (contient les parametres du disturbance)
   //
   /* this.proportional=controller1;
    this.integral=controller2;
    this.derivative=controller3;
    this.process=process;*/
    
    /*double w=arrayOfParameters[certain i];
    double c=arrayOfParameters[certain i];
    double q=arrayOfParameters[certain i];
    double v=arrayOfParameters[certain i];
    double Ti=arrayOfParameters[certain i];
    double rho=arrayOfParameters[certain i];
    double delx=arrayOfParameters[certain i];
    double tauv=arrayOfParameters[certain i];
    double kv=arrayOfParameters[certain i];
    double tChangeSP=tChangeSP;*/
    //double setPointIn=arrayOfParameters[certain i];
   
    
    double [] time=new double [timeOfSimulation];
    double [] response=new double [timeOfSimulation];
    double [] error=new double [timeOfSimulation];
    double [] propError=new double [timeOfSimulation];
    double [] intError=new double [timeOfSimulation];
    double [] derError=new double [timeOfSimulation];
    double [] signal=new double [timeOfSimulation];
    double [] setPoint=new double [timeOfSimulation];
    double [] fceOut=new double [timeOfSimulation];
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
      
    for(int i=1; i<timeOfSimulation; i++)
    {
      if (time[i]<tChangeSP)
        setPoint[i]=setPoint[0];
      else 
        setPoint[i]=setPointChange;  
          
      time[i]=time[i]+delx;
      error[i]=response[i-1]-setPoint[i];
      propError[i]=proportional.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      intError[i]=integral.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      derError[i]=derivative.calculateSignal(delx, error[i], error[i-1]);//see how to send the 2 values of error
      signal[i]=1+(propError[i]+intError[i]+derError[i]);
      
      if (tauv==0)
        fceOut[i]=kv*signal[i];
      else 
         fceOut[i]=fceOut[i-1]+delx*(kv*signal[i]-fceOut[i-1])/tauv;//j'ai ajouté * apres  +delx ici
     
      
      if (error[i]==0)
        response[i]=response[0];//verify this!!
      else
      {
        response[i]=response[i-1]+process.calculateReponseOfProcess(time[0], response[i-1], delx, fceOut[i], disturbanceChange);
      }
                                                                                        
    }
  
    return response; 
  
  }

}//end of class