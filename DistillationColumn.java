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
  
  public double calculateValueOfODE(double x, double y)
  {
    double area = Math.PI*Math.pow(this.d, 2)*0.25;
    return ((this.l - this.v)/(this.rho*area) - this.b/(this.rho*area));
  } //end of method required for interface
  
  public double calculateReponseOfProcess(double t1, double response, double delx, double fceOUT, double disturbance, String choice, double tDistStart)
  {
    double responseOfProcess = RungeKutta.integrate(t1, response, delx, this.clone()); //consider returning clone or passing original object
    
    b=fceOUT;                              //need to figure out how to make sure we don't get a negative height
    this.distMethod(choice, disturbance, t1, tDistStart);
    return responseOfProcess;    
  }//end of method required to make class concrete 
  
   public void distMethod(String choice, double distMag, double t1, double tDistStart) //ensure start > stop and disturbance will not give strange values
   {
    if(choice.equals("step")) //step change of manipulated value
      this.setL(this.l + distMag); 
    
    else if (choice.equals("ramp")) //ramp
    {
      double distCalc = distMag *(t1-tDistStart); 
      this.setL(this.l + distCalc); //
    } //end of ramp if/else
    else if(choice.equals("wave")) //wave function
    {
      double distCalc = distMag * Math.sin(t1-tDistStart); 
      this.setL(this.l + distCalc);      
    } //end of wave if/else    
    else{}
   } //end of disturbance method  
   
} //end of class