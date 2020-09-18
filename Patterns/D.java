
import java.util.Scanner;

//* * * * *       i n  j  n-i>j      n=5  sp
//  * * * *       0    5 		  		  0
//    * * *       1    4
//      * *       2    3
//        *	  	  3    2
//        	  	  4    1
//        	  	  i<n








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
