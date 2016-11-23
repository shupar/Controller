public class DistillationColumn extends Processes implements Function
{
  private double l;//disturbance
  private double v; //kept constant
  private double rho;
  private double d; //for the area
  private double b; //manipulated variable
  private final double MINIMUM = 0; //In results if the height of the water is less than MINIMUM then we need to only give 0!!!
  
  public DistillationColumn()
  {
    this.l = 0;
    this.v = 0;
    this.rho = 0;
    this.d = 0;
    this.b = 0;
  } //end of default constructor
  
  public DistillationColumn(double l, double v, double rho, double d, double b)
  {
    this.l = l;
    this.v = v;
    this.rho = rho;
    this.d = d; 
    this.b = b;
  } //end of constructor
  
  public DistillationColumn(DistillationColumn copy)
  {
    this.l = copy.l;
    this.v = copy.v;
    this.rho = copy.rho;
    this.d = copy.d; 
    this.b = copy.b;
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
   
  public double getB()
  {
    return this.b;
  } //end of accessor
  
  public void setL(double l)
  {
    this.v = l;
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
  
  public void setB(double b)
  {
    this.b = b;
  } //end of mutator
  
  public double calculateValueOfODE(double x, double y)
  {
    double area = Math.PI*Math.pow(this.d, 2)*0.25;
    return ((this.l - this.v)/(this.rho*area) - this.b/(this.rho*area));
  } //end of method required for interface
  
  public double calculateReponseOfProcess(double t1, double response, double delx, double fceOUT, double disturbance)
  {
    double responseOfProcess = RungeKutta.integrate(t1, response, delx, this.clone()); //consider returning clone or passing original object
    this.setB(fceOUT); //verify order of lines 99 and 100
    //need to figure out how to make sure we don't get a negative height
    return responseOfProcess;    
  }//end of method required to make class concrete 
  
  public void distMethod(int choice, double distMag, double time, double distStart, double distEnd)
   {
    if(choice == 1) //choice of 1 signifies step change of controlled value
      this.setL(this.l + distMag); //does it right off the bat
    else if (choice == 2) //choice of 2 means a ramp function
    {
      double slope = distMag / (distEnd - distStart);
      double distCalc = slope * (time - distStart); //need to use how long the disturbance is and not the time of simulation
      this.setL(this.l + distCalc); //slow addition of ramp to temperature
    } //end of ramp if/else
    else if (choice == 3) //choice of 3 means a ramp function
    {
      double distCalc = distMag * Math.sin(time - distStart); //need to use how long the disturbance is and not the time of simulation
      this.setL(this.l + distCalc);      
    }
   } //end of disturbance method  
} //end of class