public class Integral extends Controller 
{
  private double tauI;
  
  public Integral()
  {
    super();
    this.tauI=0.;
  }//end of default constructor  
   
  public Integral(double kC, double tauI)
  {
    super(kC);
    this.tauI=tauI;
  }//end of constructor 
  
  public Integral(Integral copy)
  {
    super(copy);
    this.tauI=copy.tauI;
  }//end of copy constructor
  
  public Integral clone()
  {
    return new Integral(this);
  }//end of clone method
  
  public void setTauI(double tauI)
  {
    this.tauI=tauI;
  }//end of mutator 
 
  public double getTauI()
  {
    return this.tauI;
  }//end of accessor
  
  public double calculateSignal(double step, int index, double[] error)
  {
    double integratedError=0.;
    for (int i=0; i<index; i++)
      integratedError+=step*error[i];
    return integratedError*getKC()/this.tauI;
    
/*     
    //Simpsons 1/3 requires even number of points
    if(error.length % 2 == 0 && error.length != 0 && error.length > 2)
    {
      for (int i =0;i<index;i++)
      {
        if (i == 0)
          integratedError += error[i];
        else if (i % 2 == 0)
          integratedError += 4*error[i];
        else if (i % 2 != 0)
          integratedError += 2*error[i];
      } //end loop
    } //end if
    integratedError = integratedError*step/3.0
    
    Simpsons 3/8 requires an odd number of points
    if(error.length % 2 =! 0 && error.length != 0 && error.length > 2)
    {
      for (int i =0;i<index;i++)
      {
        if (i == 0)
          integratedError += error[i];
        else if (i % 2 == 0)
          integratedError += 3*error[i];
        else if (i % 2 != 0)
          integratedError += 2*error[i];
      } //end loop   
    } //end if
    integratedError = 3.0*integratedError*step/8.0
*/    
  }
}