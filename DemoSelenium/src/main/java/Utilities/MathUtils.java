package Utilities;

public class MathUtils {

	
	public static int addTowNumber(int a, int b)
	{
		 
		System.out.println("The Two numbers Entered are "+a+" and "+b);
		int c=a+b;
		System.out.println("The returning added value is "+c);
		return c;
		
	}
	
	public static int subtractTwoNumber(int a, int b)
	{
		System.out.println("The Two numbers Entered are "+a+" and "+b);
		
		if(a<b)
		{
			a=b;
		}
		int c=a-b;
		System.out.println("The subtracted value is "+c);
		return c;
		
	}
	
	public static int multiplyTwoNumber(int a, int b)
	{
		System.out.println("The Two numbers Entered are "+a+" and "+b);
		
		if(a==0 || b==0)
		{
			return 0;
		}
		
		int c=a*b;
		
		System.out.println("The multiplied value is "+c);
		return c;
	}
	
	public static int devideTwoNumber(int a, int b)
	{
		System.out.println("The Two numbers Entered are "+a+" and "+b);
		int c=0;
		try
		{
			c=a/b;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("An exception has occured "+e.getMessage());
			return 0;
		}
		
		return c;
		
	}
	
	public static int getSqure(int a)
	{
		System.out.println("Entered Number is "+a);
		
		int sqr=a*a;
		
	    System.out.println("Square of the entered value is "+sqr);
	    return sqr;
		
	}
	
	public static double getSqrRoot(int num)
	{
		System.out.println("The Entered Number is "+num);
		double sqrt=Math.sqrt(num);
		
		System.out.println("Square root value of the entered num is "+sqrt);
		return sqrt;
		
	}
	
	public static boolean checkEven(int num)
	{
		System.out.println("The Entered Number is "+num);
		boolean status=num%2==0;
		
		if(status)
		{
			System.out.println("Entered number is an even number");
		}
		else
		{
			System.out.println("Its an Odd number");
		}
		return status;
	}
	
	public static boolean isOdd(int num)
	{
		System.out.println("The Entered Number is "+num);
		boolean status=num%2!=0;
		
		if(status)
		{
			System.out.println("Entered number is an odd number");
			
		}
		else
		{
			System.out.println("Its an even number");
		}
		return status;
	}
	
	
	public static boolean isPrime(int num)
	{
		
		System.out.println("The Entered Number is "+num);
		boolean status=false;
		
		if(num<2)
		{
		status=false;
		}
		for(int i=2;i<num;i++)
		{
			if(num%i==0)
			{
			status=false;	
			break;
			}
			else
			{
				status=true;
			}
		}
		
		return status;
		
	}
	
	public static int getFactorial(int num)
	{
		System.out.println("The Entered Number is "+num);
		
		int fact=1;
		for(int i=1;i<num;i++)
		{
		fact=fact*i;	
		}
		
		System.out.println("Factorial of the given number is "+fact);
		return fact;
		
	}
	
	public static int maxNumber(int num[])
	{
		
		System.out.println("Entered collection of numbers are "+num);
		
		int max=num[0];
		for(int i=0;i<num.length;i++)
		{
			if(num[i]>max)
			{
				max=num[i];
			}
		}
		System.out.println("The Max value from the given array is "+max);
		return max;
		
	}
	
	public static int minNumber(int num[])
	{
System.out.println("Entered collection of numbers are "+num);
		
		int min=num[0];
		for(int i=0;i<num.length;i++)
		{
			if(num[i]<min)
			{
				min=num[i];
			}
		}
		System.out.println("The Max value from the given array is "+min);
		return min;
	}
	
	public static int getAverage(int num[])
	{
		
		System.out.println("Entered collection of numbers are "+num);
		int avg=0;
		int sum=0;
		for(int i=0;i<num.length;i++)
		{
			sum=sum+num[i];
			avg=sum/num.length;
		}
		System.out.println("The average of the numbers "+avg);
		return avg;
		
	}
	
	
}
