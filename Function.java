//interface to connet ODE equations to the RK4 classes
public interface Function
{
   public double calculateValueOfODEDisturbance(double x, double y);
   public double calculateValueOfODEManipulated(double x, double y);
}
