//		sp(n-i)	i(n)	j(i)
//     *	4	1		1
//    **	3	2		2
//   ***	2	3		3
//  ****	1	4		4
// *****	0	5		5


import java.util.*;
public class A {
	public static void main(String[] args)
		{ int n;
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the no. of rows =");
		  n= sc.nextInt();
		  for(int i=1;i<=n;i++)
		  	{ for(int sp=1;sp<=(n-i); sp++)
		  			System.out.print(" ");
		  	  for(int j=1; j<=i;j++)
		  	  		System.out.print("*");

		  	  System.out.println();
		  	}

		}
}
