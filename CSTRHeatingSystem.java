public class CSTRHeatingSystem extends Processes implements Function
  
{
   //private double[] opConditions; c.a.d c,w,Ti,Q,V,rho
   
   
  /* public CSTRHeatingSystem()
   {
       //force null values for these instance variables,
       //which will be reset each time calculateResponse is called...
     
       this.opConditions=null;
    }*/

  public double [] calculateReponse(disturbance=To, step change in q, t)//arranger ca apres, on va essayer step change avant
  {
    //this.opConditions=opConditions;
    
    double delt=t/5000;
    double maxIt=5001;
      
    return RungeKutta.integrate(0, t, 25, delt, maxIt, this);
  }
  
  
  public double calculateValue(double t, double T);
  {
   double c,w,,v,rho;//normalment dans la table opConditions
   double To,q; //c'est different pour ces 2 variables pcq To=disturbance et Q=step change
   return  (w*C*(To-T)+q)/(v*rho*c)
  }//end of method
  
}//end of concentration model