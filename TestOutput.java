import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class TestOutput
{
  public static void main (String [] args)
  {
    PrintWriter outputStream=null;
    
    try
    {
      outputStream=new PrintWriter(new FileOutputStream("TestOutput.xls"));
    }//end try block
    
    catch(FileNotFoundException e)
    {
      System.out.println("Error opening TestOutput");
      System.exit(0);
    }//end catch
    
    double[] resultsArray={1,2,3,4,5,6,7,8,9};
    
    
    outputStream.println("t [s]\tH(t) [m]");
       
    for (int i=0; i<resultsArray.length; i++)
    {
      outputStream.println(i+"\t"+resultsArray[i]);      
    }
    
    outputStream.println("Hello \tmy \n\tname \ris \r\nemily");
    outputStream.close();
  }//end main

}//end testOutput class