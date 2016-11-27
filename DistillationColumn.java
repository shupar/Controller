public class DistillationColumn extends Processes implements Function
{
  private double l;//disturbance
  private double v; //kept constant
  private double rho;
  private double area; //for the area
  private double initialHeight;

  public double b;
  //private final double MINIMUM = 0; //In results if the height of the water is less than MINIMUM then we need to only give 0!!!
  
  public DistillationColumn()
  {
    this.l = 0;
    this.v = 0;
    this.rho = 0;
    this.area = 0;
  } //end of default constructor
  
  public DistillationColumn(double area, double rho, double l, double v, double initialHeight)
  {
    this.l = l;
    this.v = v;
    this.rho = rho;
    this.area = area;
    this.initialHeight = initialHeight;
  } //end of constructor
  
  public DistillationColumn(DistillationColumn copy)
  {
    this.l = copy.l;
    this.v = copy.v;
    this.rho = copy.rho;
    this.initialHeight = initialHeight;
    this.area = copy.area;
    
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
  
  public double getArea()
  {
    return this.area;
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
  
  public void setArea(double area)
  {
    this.area = area;
  } //end of mutator
  

  
  public double calculateValueOfODEDisturbance(double x, double y)
  {
  
    return ((this.l)/(this.rho*this.area) );
  } //end of method required for interface
  
 
   public double calculateValueOfODEManipulated(double x, double y)
   {
     
     return  (- this.b/(this.rho*this.area)-(this.v)/(this.rho*this.area));
   }//end of method
  
  
  public double calculateReponseOfProcessDisturbance(double t1, double responseL, double delx, double fceOUT, double disturbance)
   {
     //this.setL(disturbance + this.l);
     
     double responseinL=Euler.integrate(t1,responseL, delx, this);
   
     return responseinL;
   }//using the static method in Euler function to solve it   
  
   
   public double calculateReponseOfProcessManipulated(double t1, double responseB, double delx, double fceOUT, double disturbance)
   {
     b=-fceOUT;
     
     double responseinB=Euler2.integrate(t1,responseB, delx, this);
    
     return responseinB;
   }//using the static method in Euler2 function to solve it   
   
   public double intialiseControlledVariable()
   {
    return this.initialHeight; 
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