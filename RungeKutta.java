public class RungeKutta

{ 
  public static double integrate(double x_0, double x_f, double y_0, double delx, int maxIt, Function f)
  {
    
        double y;
        double x;
        double x=x_0;
        double y=y_0;
        //int i=0;
          
        //communicate with the Function object, asking it for the right-hand-side value of the ode, given the current
        //values of x and y. This is accomplished through the Function object's calculateValue method
       // while(x<=x_f && i<maxIt)
        //{
          double k1, k2, k3, k4;
          
          k1=f.calculateValue(x,y);
          k2=f.calculateValue(x+(delx*/2), y+(delx*k1/2));
          k3=f.calculateValue(x+(delx*/2), y+(delx*k2/2));
          k4=f.calculateValue(x+delx,y+(delx*k3));
            
          y=y+delx*(k1+(2*k2)+(2*k3)+k4)/6;
          x=x+delx;
          //i++;
          
          return y; //je pense qu'on devrait retourner x[i] egalement
       // }

        //if(i==maxIt) System.out.println("endpoint not reached within maximum specified initerations in RK4 integrate method");
        
    }//end of integrate method
  
}//end of RK4 class