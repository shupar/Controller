public class Euler2

{ 
public static double integrate(double x_0, double y_0, double delx, Function f)// initial time, 
  {
    double x=x_0;
    double y=y_0;
    
    //communicate with the Function object, asking it for the right-hand-side value of the ode, given the current
    //values of x and y. This is accomplished through the Function object's calculateValueOfProcess method
       
    double k1; 
          
     k1 = f.calculateValueOfODEManipulated(x,y);

      y=y+delx*k1;

          
    return y;
    
    }//end of integrate method
}//end of Euler2 class