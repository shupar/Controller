public abstract class ControllerEssay 
{  
  private double kC;
  
  public ControllerEssay()
  {
    this.kC=0.;
  }//end of default constructor  
   
  public ControllerEssay(double kC)
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
  
  public abstract double calculateSignal(double error);
   
} //end of class
  