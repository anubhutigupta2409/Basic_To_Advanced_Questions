 //			sp				j				i(n)
//     *	4				1 				1
//   * * *	2				3 				2
// * * * * *0 2*(n/2 + 1-i)	5	2*i -1		3 (n/2 + 1)
//
//   * * *	2				3				2
//     *	4 				1	2*i - 1		1 n/2
// if n=5



import java.util.*;

public class B {
	public static void main( String[] args)
		{ Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the no. of rows(odd no. only) = ");
		  int n = sc.nextInt();
		  for(int i = 1; i<=(n/2 +1) ; i++)
		  	{
		  		for(int sp = 1 ; sp<= 2*(n/2 + 1 - i); sp++)
		  			System.out.print(" ");

				for(int j = 1 ; j<= 2*i - 1; j++)
					System.out.print("* ");

				System.out.println();

			}
		 for (int i = n/2 ; i>=1 ; i--)
		 	{	for (int sp= 1 ; sp<=2*(n/2 + 1 -i); sp++)
		 			System.out.print(" ");

		 		for (int j=1; j<= 2*i - 1 ; j++ )
		 			System.out.print("* ");

		 		System.out.println();
			}



		}
}