package Package123;

public class TryCatch {
	
	public static void main(String[] args) 
	{
		
		System.out.println("start");
		
		int a = 15;
		int b = 0;
		int c ;
		
		try
		{
			c = a/b;
			System.out.println();
		}
	
		
		catch(Exception e)
		{
			b = 5;
			c = a/b;
			System.out.println(c);
			
		}
							
	}
}


