public class Results extends ControllerEssay implements Processes//figure out how to do it because processes is an abstract class
  
{
  ControllerEssay []controller;
  Processes []process;
  
  //add constructor
  
  public double calculations(step change, disturbance, controller, process, arrayOfParameters(Kc,TauI,TauD,T,t,V,deltax,etc..))
  {
    this.controller=controller;
    this.process=process;
    this.controller=new Controller[i];
    this.process=new Processes[i];
    
    double kc=arrayOfParameters[certain i];
    double taui=arrayOfParameters[certain i];
    double taud=arrayOfParameters[certain i];
    double delx=arrayOfParameters[certain i];
    double maxIt=arrayOfParameters[certain i];
    
    For(int i=0; i<choose depending on delx; i++)
    {
      double time=fct de i;
      double fceOUT=this.controller[i].calculateSignal(step change, kc,taui, taud);
      double response=this.process[i]calculateReponse(x_0, x, y_0, delx, maxIt, Function f, double time, double response, double fceOUT);
      
      return response;                             
    }
  
  }

}//end of class