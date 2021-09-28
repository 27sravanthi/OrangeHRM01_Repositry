package Return_value;

import org.testng.annotations.Test;

public class Single_value {
	
	
  @Test
  public void Test() {
	  
	  Single_value R1= new Single_value();
	  String str1;
		
		str1= R1.addstrings("Sravanthi");
		System.out.println("updated string value is " +str1);
		
        int d= R1.Add(30,40);
		System.out.println("sum of a,b " +d);
		//System.out.println("___****Sum ****_____" );
		
		
		int e= R1.multiplication(50,40);
		System.out.println("multiplication of a,b " +e);
		//System.out.println("___****Mul ****_____" );
		

		int f= R1.subtract(50,60);
		System.out.println("subtract of a,b " +f);
		
		

		int g= R1.division(20,10);
		System.out.println("division of a,b " +g);
		
		
		int si=simpleInterest(5000,2,10);
		System.out.println("Simple Interst " +si);
		
	  
  }
  
  public String addstrings(String str)
	{
		
		String str2=str + "Pamulapati";
		
		return str2;
	}
  
  
	
	
	//method with arguements
	public int Add(int a,int b)
	{
	//System.out.println("a value is" +a);
	//System.out.println("b value is" +b);
	
	int d=a+b;
	System.out.println("Sum of a,b " +d);
	return d;
	}
	
	

	//method with arguements
	public int multiplication(int a,int b)
	{
	//System.out.println("a value is" +a);
	//System.out.println("b value is" +b);
	
	int e=a*b;
	System.out.println("Multiplification of a,b " +e);
	return e;
	}
	

	//method with arguements
	public int subtract(int a,int b)
	{
	//System.out.println("a value is" +a);
	//System.out.println("b value is" +b);
	
	int f=a-b;
	System.out.println("Substract of a,b " +f);
    return f;
	}

	
	//method with arguements
	public int division(int a,int b)
	{
	//System.out.println("a value is" +a);
	//System.out.println("b value is" +b);
	
	int g=a/b;
	System.out.println("Division of a,b " +g);
	return g;
	}
	

	public int simpleInterest(int p,int t,int r)
	{
		
		int si=(p*t*r)/100;
		System.out.println("Simple Inerest " +si);
		return si;
	}
  
  
  
}
