public class CSTRHeatingSystem extends Processes implements Function
  
{
   private double[6] opConditions; // Volume, density, heatCapacity, inlet temp, flow rate, heat flow
   //size here isnt right. i changed it to 6
   
   public CSTRHeatingSystem()
   {
       //force null values for these instance variables,
       //which will be reset each time calculateResponse is called...
     
       this.opConditions=null;
    }
   public CSTRHeatingSystem(double v, double rho, double cp, double t_I, double w, double q) // will most likely be recieved by file I/O therefore not at array
   {
    this.opCondition[0] = v;
    this.opCondition[1] = rho;
    this.opCondition[2] = cp;//idk why this variable was kept as heatCapacity. i changed it to cp (the variable name that is received
    this.opCondition[3] = t_I;
    this.opCondition[4] = w;
    this.opCondition[5] = q;    
   }
   
   public void setV(double v)
   {
     this.opCondition[0] = v;
   } //end of mutator
   
   public void setRho(double rho)
   {
     this.opCondition[1] = rho;
   } //end of mutator

   public void setHeatCapacity(double cp)
   {
     this.opCondition[2] = c;
   } //end of mutator
   
   public void setT_I(double t_I)
   {
     this.opCondition[3] = t_I;
   } //end of mutator
   
   public void setT_I(double t_I)
   {
     this.opCondition[3] = t_I;
   } //end of mutator
       

  public double [] calculateReponse(disturbance=To, step change in q, t)//arranger ca apres, on va essayer step change avant
  {
    //this.opConditions=opConditions;
    
    double delt=t/5000;
    double maxIt=5001;
      
    return RungeKutta.integrate(0, t, 25, delt, maxIt, this);
  }
  
  
  public double calculateValue(double x, double y);//needs same signature as the interface!!!! i changed (double t, double T) to double x, double y)
  {
   double c,w,,v,rho;//normalment dans la table opConditions
   double To,q; //c'est different pour ces 2 variables pcq To=disturbance et Q=step change
   return  (w*C*(To-y)+q)/(v*rho*c)
  }//end of method
  
}//end of concentration model