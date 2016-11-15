public class CSTRHeatingSystem extends Processes implements Function
  
{
   private double[] opCondition = new double[6]; // Volume, density, heatCapacity, inlet temp, flow rate, heat flow
   //size here isnt right. i changed it to 6
   
   public CSTRHeatingSystem()
   {
       //force null values for these instance variables,
       //which will be reset each time calculateResponse is called...
     
       this.opCondition=null;
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
     this.opCondition[2] = cp;
   } //end of mutator
   
   public void setT_I(double t_I)
   {
     this.opCondition[3] = t_I;
   } //end of mutator
   
   public void setW(double w)
   {
 
     this.opCondition[4] = w;
   } //end of mutator
   
   public void setQ(double q)
   { 
     this.opCondition[5] = q;
   } //end of mutator
////////////////////
    public double getV()
   {
     this.opCondition[0] = v;
   } //end of mutator
   
   public double getRho()
   {
     this.opCondition[1] = rho;
   } //end of mutator

   public double getHeatCapacity()
   {
     this.opCondition[2] = cp;
   } //end of mutator
   
   public double getT_I()
   {
     this.opCondition[3] = t_I;
   } //end of mutator
   
   public double getW()
   {
 
     this.opCondition[4] = w;
   } //end of mutator
   
   public double getQ()
   { 
     this.opCondition[5] = q;
       
   public double calculateValue(double x, double y)//needs same signature as the interface!!!! i changed (double t, double T) to double x, double y)
   {
   return  (this.opCondition[4]*this.opCondition[2]*(this.opCondition[3]-y)+this.opCondition[5])/(this.opCondition[0]*this.opCondition[1]*this.opCondition[2]);
   }//end of method
  
   public double calculateResponse(double t1, double t2, double y0)
   {
   RungeKutta.integrate(t1,t2,y0, 0.2/*arbitrary step size*/,1000, this);
   } //using the static method in RK function to solve it
  
}//end of concentration model