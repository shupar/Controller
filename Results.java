public class Results extends Controller implements Processes
{
  Proportional []proportional;
  Integral []integral;
  Derivative []derivative;
  
  CSTRHeatingSystem []cstrHeatingSystem;//for the moment just for this process without disturbance
 
  
  public double calculations(step change, disturbance, controller1, controller2, controller3 process, arrayOfParameters(T,t,V,deltax,etc..))
  {
    this.proportional=controller1;
    this.integral=controller2;
    this.derivative=controller3;
    this.cstrHeatingSystem=process;
    this.proportional=new Controller[i];
    this.integral=new Controller[i];
    this.derivative=new Controller[i];
    
    double w=arrayOfParameters[certain i];
    double c=arrayOfParameters[certain i];
    double q=arrayOfParameters[certain i];
    double v=arrayOfParameters[certain i];
    double Ti=arrayOfParameters[certain i];
    double rho=arrayOfParameters[certain i];
    double delx=arrayOfParameters[certain i];
    double tauv=arrayOfParameters[certain i];
    double kv=arrayOfParameters[certain i];
    double tChangeSP=arrayOfParameters[certain i];
    double setPointIn=arrayOfParameters[certain i];
    double timeOfSimulation=arrayOfParameters[certain i];
    double maxIt=arrayOfParameters[certain i];
    
    double [] time=new double [timeOfSimulation];
    double [] response=new double [timeOfSimulation];
    double [] error=new double [timeOfSimulation];
    double [] propError=new double [timeOfSimulation];
    double [] intError=new double [timeOfSimulation];
    double [] derError=new double [timeOfSimulation];
    double [] signal=new double [timeOfSimulation];
    double [] setPoint=new double [timeOfSimulation];
    double [] fceOut=new double [timeOfSimulation];
    
    time[0]=-delx;
    response[0]=(w*c*(Ti-T)+q)/(v*rho*c);
    error[0]=0;
    propError[0]=0;
    intError[0]=0;
    derError[0]=0;
    signal[0]=1+(propError[0]+intError[0]+derError[0]);
    setPoint[0]=(w*c*(Ti-320(T))+q)/(v*rho*c);//verify this
    
    if (tauv=0)
      double fceOut[0]=kv*signal[0];
    else 
      double fceOut[0]=kv*signal[0]/tauv;
      
    For(int i=1; i<choose depending on delx; i++)
    {
      if (time[i]<tChangeSP)
        setPoint[i]=setPoint[0];
      else 
        setPoint[i]=setPointIn;  
          
      time[i]=time[i]+delx;
      error[i]=response[i]-setPoint[i];
      propError[i]=this.proportional[i].calculateSignal(step, error[i], error[i-1]);//see how to send the 2 values of error
      intError[i]=this.integral[i].calculateSignal(step, error[i], error[i-1]);//see how to send the 2 values of error
      derError[i]=this.proportional[i].calculateSignal(step, error[i], error[i-1]);//see how to send the 2 values of error
      signal[i]=1+(propError[i]+intError[i]+derError[i]);
      
      if (tauv=0)
        fceOut[i]=kv*signal[i];
      else 
         fceOut[i]=fceOut[i-1]+delx(kv*signal[i]-fceOut[i-1])/tauv;
      
      if (error[i]=0)
        response[i]=(w*c*(Ti-320(T))+q)/(v*rho*c);//verify this!!
      else 
        response[i]=response[i-1]+this.cstrHeatingSystem[i].calculateReponse(x_0, x, y_0, delx, maxIt, Function f,
                                                                             double time, double response[i-i], double fceOUT[i]);
   
      return response;                             
    }
  
  }

}//end of class