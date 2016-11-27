//CSTRHeating System is a child of Processes and implements Funtion to access RungeKutta
public class CSTRHeatingSystem extends Processes implements Function

{
   //declaring instance varibales
   private double v;
   private double rho;
   private double cp;
   private double t_I;
   private double w;
   
   //CSTR local variable used to get the fceOUT variable from CalculateResponseOfProcessManipulated to CalculateValueOfODEManipulated
   public double q;
   
   //Making constructors and clone method:
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
   
   //Mutator methods:
   public void setV(double v)
   {
    this.v = v;
   } //end of mutator for c
   
   public void setRho(double rho)
   {
    this.rho = rho;
   } //end of mutator for rho

   public void setCp(double cp)
   {
    this.cp = cp;
   } //end of mutator for cp
   
   public void setT_I(double t_I)
   {
    this.t_I = t_I;
   } //end of mutator for intitial T
   
   public void setW(double w)
   { 
    this.w = w;
   } //end of mutator for w

   //accessor methods:
    public double getV()
   {
    return this.v;
   } //end of accessor for v
   
   public double getRho()
   {
    return this.rho;
   } //end of accessor for rho

   public double getCp()
   {
    return this.cp;
   } //end of accessor for cp
   
   public double getT_I()
   {
    return this.t_I;
   } //end of accessor for initial T
   
   public double getW()
   { 
    return this.w;
   } //end of accessor for w
   
   //concrete implementation for the disturbance ODE solver
   public double calculateValueOfODEDisturbance(double x, double y)//(double t, double T) 
   {
    return  ((this.w*this.cp*(this.t_I-y))/(this.rho*this.cp*this.v));
   }//end of method
 
   //concrete implementation for the manipoulated variable ODE solver
   public double calculateValueOfODEManipulated(double x, double y)
   {
    return  (q/(this.rho*this.cp*this.v));
   }//end of method
   
   //concrete implementation for the response of the process' disturbance
   public double calculateReponseOfProcessDisturbance(double t1, double responseTi, double delx, double fceOUT, double disturbance)
   {
     double responseinTi=RungeKutta.integrate(t1,responseTi, delx, this);
   
     return responseinTi;
   }//using the static method in RK function to solve it   
   
   //concrete implementation for the response of the process with respects to the manipulated variable
   public double calculateReponseOfProcessManipulated(double t1, double responseQ, double delx, double fceOUT, double disturbance)
   {
     q=fceOUT;
     
     double responseinQ=RungeKutta2.integrate(t1,responseQ, delx, this);
    
     return responseinQ;
   }//using the static method in RK2 function to solve it   
   
   public double intialiseControlledVariable()
   {
    return this.getT_I(); 
   } //end of method to return T
   
    public double intialiseDisturbanceArray()
   {
    return this.getT_I(); 
   } //end of method to return T
    
    //Method for disturbance start time
    public void turnOnDisturbance(double magnitude)
    {
      this.setT_I(this.t_I + magnitude);
    } //end of method
    
    //method for disturbance end time
    public void turnOffDisturbance(double magnitude)
    {
      this.setT_I(this.t_I - magnitude);
    } //end of method
    
     public double intialiseManipulatedVariable()
    {
     return 0;
    }
   
}//end of heating model