public class LevelControlSystem extends Process implements Function
{
  private double d;
  private double tankHeight;
  private double cvStar;
  private double hInit;
  private double hStar;
  private double q;
  public static final GRAV = 9.807;
  
  public LevelControl()
  {
    this.d = 0;
    this.tankHeight = 0;
    this.cvStar = 0;
    this.hInit = 0;
    this.hStar = 0;
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
  
  public LevelControlSystem clone()
  {
   return new LevelControlSystem(this); 
  } //end of clone method
  
  public double calculateValue(double x, double y)
  {
    double cV = this.cvStar * Math.sqrt(GRAV);
    double area = 0.25 * Math.pi * Math.pow(d,2);
    return ((this.q - cV * Math.sqrt(x)) / area);
  } //end of method
  
  
  
} //end of class