public abstract class Controller
{  
  private double kC;
  
  public Controller()
  {
    this.kC=0.;
  }//end of default constructor  
   
  public Controller(double kC)
  {
    this.kC=kC;
  }//end of constructor 
  
  public void setKC (double kC)
  {
    this.kC=kC;
  }//end of mutator 
 
  public double getKC()
  {
    return this.kC;
  }//end of accessor
  
  public abstract double calculateSignal(double step, int index, double[] error);
   
} //end of class
  