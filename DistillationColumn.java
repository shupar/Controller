public class DistillationColumn extends Processes implements Function
{
  private double l;//will be kept constant
  private double v; //will used for the disturbance
  private double rho;
  private double d; //for the area
  private double b; //manipulated variable
  
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
    this.setB(fceOUT);
    return responseOfProcess;    
  }//end of method required to make class concrete 
  
//  public double disturbanceMethod(double disturbanceMagnitude)
//  {
//    this.v = this.v + disturbanceMagnitude;
//  } //end of method
  
} //end of class