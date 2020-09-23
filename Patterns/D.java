
import java.util.Scanner;

//* * * * *       i n  p  n-i>p      n=5  spaces(twice)
//  * * * *       0    5 		  0
//    * * *       1    4		  1	
//      * *       2    3		  2  
//        *	  3    2		  3
//        	  4    1		  4
//        	  i<n








public class D{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n= sc.nextInt();
		for(int i=0 ; i<n ; i++)
		{
			for(int j = 0; j<i; j++)
			{
				System.out.print("  ");
			}
			for( int p=0 ; p<n-i ; p++)
			{
				System.out.print("* ");
			}

			System.out.println();
		}
	}

}
