public class LevelControlSystem extends Processes implements Function
{
  public static final double GRAV = 9.807;  
  private double d;
  private double tankHeight;
  private double cvStar;
  private double hInit;
  private double hStar;
  private double q;
  
  public LevelControlSystem()
  {
    super();//right?????????????????????????????????????????
    this.d = 0;
    this.tankHeight = 0;
    this.cvStar = 0;
    this.hInit = 0;
    this.hStar = 0;//not sure about this variable. I think it is the same as if user choses to change setpoint
    this.q = 0;
  }//end of default constructor
  
  public LevelControlSystem(double d, double tankHeight, double cvStar, double hInit, double hStar, double q)
  {
    this.d = d;
    this.tankHeight = tankHeight;
    this.cvStar = cvStar;
    this.hInit = hInit;
    this.hStar = hStar;
    this.q = q;
  } //end of constructor
  
  public LevelControlSystem(LevelControlSystem copy)
  {
    this.d = copy.d;
    this.tankHeight = copy.tankHeight;
    this.cvStar = copy.cvStar;
    this.hInit = copy.hInit;
    this.hStar = copy.hStar;
    this.q = copy.q;
  } //end of copy constructor
  
  public double getHStar()
  {
    return this.hStar;
  } //end of accessor
  
  public void setHStar(double hStar)
  {
    this.hStar = hStar;
  } //end of mutator
  
  public double getQ()
  {
   return this.q;
  } // end of accessor
  
  public void setQ(double q)
  {
   this.q = q; 
  } //end of mutator
  
  public void setHInit(double hInit )
  {
   this.hInit= hInit; 
  } //end of mutator
  
  public LevelControlSystem clone()
  {
   return new LevelControlSystem(this); 
  } //end of clone method
  
  public double calculateValueOfODE(double x, double y)//(double t, double H)
  {
    double cV = this.cvStar * Math.sqrt(GRAV);
    double area = 0.25 * Math.PI * Math.pow(this.d,2);
    return ((this.q - cV * Math.sqrt(y)) / area);
  }//end of method
  
  
  public double calculateResponseOfProcess(double t1, double response, double delx, double fceOUT, double disturbance)
  {
   double responseOfProcess=RungeKutta.integrate(t1,response, delx, this);
    this.setQ(fceOUT);
    this.setHInit(disturbance + this.hInit);
    
    return responseOfProcess;
  }//make this specific to level!!!!!!!!!!!!!!using the static method in RK function to solve it

} //end of class