public class CSTRHeatingSystem extends Processes implements Function
  //verify the necessity of certain accessors and mutator methods
{
   private double v;
   private double rho;
   private double cp;
   private double t_I;
   private double w;
   
   public double q;
   
    public CSTRHeatingSystem()
   {
    this.v = 0;
    this.rho = 0;
    this.cp = 0;
    this.t_I = 0;
    this.w = 0;
      
    } //end of default constructor
   
   public CSTRHeatingSystem(double t_I, double rho, double v,  double w, double cp) // will most likely be recieved by file I/O therefore not at array
   {
    this.v = v;
    this.rho = rho;
    this.cp = cp;
    this.t_I = t_I;
    this.w = w;
      
   } //end of constructor
   
   public CSTRHeatingSystem(CSTRHeatingSystem copy)
   {
    this.v = copy.v;
    this.rho = copy.rho;
    this.cp = copy.cp;
    this.t_I = copy.t_I;
    this.w = copy.w;
    
   } //end of copy constructor
   
   public CSTRHeatingSystem clone()
   {
    return new CSTRHeatingSystem(this);
   } //end of clone method
   
   public void setV(double v)
   {
    this.v = v;
   } //end of mutator
   
   public void setRho(double rho)
   {
    this.rho = rho;
   } //end of mutator

   public void setHeatCapacity(double cp)
   {
    this.cp = cp;
   } //end of mutator
   
   public void setT_I(double t_I)
   {
    this.t_I = t_I;
   } //end of mutator
   
   public void setW(double w)
   { 
    this.w = w;
   } //end of mutator

    public double getV()
   {
    return this.v;
   } //end of mutator
   
   public double getRho()
   {
    return this.rho;
   } //end of accessor

   public double getHeatCapacity()
   {
    return this.cp;
   } //end of accessor
   
   public double getT_I()
   {
    return this.t_I;
   } //end of accessor
   
   public double getW()
   { 
    return this.w;
   } //end of accessor
       
   public double calculateValueOfODE(double x, double y)//(double t, double T) 
   {
    return  (this.w/(this.v*this.rho))*((this.t_I-y)+(q/(this.rho*this.cp*this.v)));
   }//end of method
  
   public double calculateReponseOfProcess(double t1, double response, double delx, double fceOUT, double disturbance, String choice, double tDistStart)
   {
   double responseOfProcess=RungeKutta.integrate(t1,response, delx/*arbitrary step size*/, this);//NOT ARBITRARY, USER DEFINES IT, address this and consider passing a clone
    q=fceOUT;
    this.distMethod(choice, disturbance, t1, tDistStart);
    return responseOfProcess; 
   }//using the static method in RK function to solve it   
   
   public void distMethod(String choice, double distMag, double t1, double tDistStart) //ensure start > stop and disturbance will not give strange values
   {
    if(choice.equals("step")) //step change of manipulated value
      this.setT_I(this.t_I + distMag); 
    
    else if (choice.equals("ramp")) //ramp
    {
      double distCalc = distMag *(t1-tDistStart); 
      this.setT_I(this.t_I + distCalc);
    } //end of ramp if/else
    
    else if(choice.equals("wave")) //wave function
    {
      double distCalc = distMag * Math.sin(t1-tDistStart); //need to use how long the disturbance is and not the time of simulation
      this.setT_I(this.t_I + distCalc);      
    } //end of wave if/else    
    else{}
   } //end of disturbance method  
   
}//end of heating model