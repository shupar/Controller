public class Results extends Controller//figure out how to do it because Processes is an abstract class
  //n'est ce pas qu'on voulait caller les affaires avec des objets? wait you cant instantiate an abstract class.... fuck





{
  Controller []controller;
  Processes []process;
  
  //add constructor
  
  public double calculations(step change, disturbance, controller, process, arrayOfParameters(Kc,TauI,TauD,T,t,V,deltax,etc..))
  
  {
    this.controller=controller;
    this.process=process;
    this.controller=new Controller[i];
    this.process=new Processes;
    
    double kc=arrayOfParameters[certain i];
    double taui=arrayOfParameters[certain i];
    double taud=arrayOfParameters[certain i];
    double delx=arrayOfParameters[certain i];
    double maxIt=arrayOfParameters[certain i];
    
    double response[0]=0;
    
    For(int i=0; i<choose depending on delx; i++)
    {
      double time=i; //time will be in seconds
      double fceOUT[i]=this.controller[i].calculateSignal(step change, kc,taui, taud, response);
      double response[i]= this.process[i].calculateReponse(i, i+1, y_0);
       
      return response;                             
    }
  
  }

}//end of class