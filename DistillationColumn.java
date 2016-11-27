public class DistillationColumn extends Processes implements Function
{
  private double l;//disturbance
  private double v; //kept constant
  private double rho;
  private double d; //for the area

  public double b;
  //private final double MINIMUM = 0; //In results if the height of the water is less than MINIMUM then we need to only give 0!!!
  
  public DistillationColumn()
  {
    this.l = 0;
    this.v = 0;
    this.rho = 0;
    this.d = 0;
  } //end of default constructor
  
  public DistillationColumn(double d, double rho, double l, double v)
  {
    this.l = l;
    this.v = v;
    this.rho = rho;
    this.d = d; 
  } //end of constructor
  
  public DistillationColumn(DistillationColumn copy)
  {
    this.l = copy.l;
    this.v = copy.v;
    this.rho = copy.rho;
    this.d = copy.d; 
    
  } //end of copy constructor
  
  public DistillationColumn clone()
  {
    return new DistillationColumn(this);
  } //end of clone method
  
  public double getL()
  {
    return this.l;
  } //end of accessor
    
  public double getV()
  {
    return this.v;
  } //end of accessor
   
  public double getRho()
  {
    return this.rho;
  } //end of accessor
  
  public double getD()
  {
    return this.d;
  } //end of accessor
  
  public void setL(double l)
  {
    this.l = l;
  } //end of mutator
  
  public void setV(double v)
  {
    this.v = v;
  } //end of mutator
  
  public void setRho(double rho)
  {
    this.rho = rho;
  } //end of mutator
  
  public void setD(double d)
  {
    this.d = d;
  } //end of mutator
  
  double area = Math.PI*Math.pow(this.d, 2)*0.25;
  
  public double calculateValueOfODEDisturbance(double x, double y)
  {
    
    return ((this.l - this.v)/(this.rho*area) );
  } //end of method required for interface
  
 
   public double calculateValueOfODEManipulated(double x, double y)
   {
    return  (- this.b/(this.rho*area));
   }//end of method
  
  
  public double calculateReponseOfProcessDisturbance(double t1, double responseL, double delx, double fceOUT, double disturbance)
   {
     //this.setL(disturbance + this.l);
     
     double responseinL=RungeKutta.integrate(t1,responseL, delx, this);
   
     return responseinL;
   }//using the static method in RK function to solve it   
  
   
   public double calculateReponseOfProcessManipulated(double t1, double responseB, double delx, double fceOUT, double disturbance)
   {
     b=fceOUT;
     
     double responseinB=RungeKutta2.integrate(t1,responseB, delx, this);
    
     return responseinB;
   }//using the static method in RK function to solve it   
   
   public double intialiseControlledVariable()
   {
    return ((this.l - this.v - this.b)/((Math.pow(this.d, 2)*Math.PI*0.25))); 
   } //end of method
  
   public double intialiseDisturbanceArray()
   {
    return 0; //for the time being
   } //end of method
   
    public void turnOnDisturbance(double magnitude)
    {
      this.setL(this.l + magnitude);
    } //end of method
    
    public void turnOffDisturbance(double magnitude)
    {
      this.setL(this.l - magnitude);
    } //end of method
  
  

  
   
} //end of class