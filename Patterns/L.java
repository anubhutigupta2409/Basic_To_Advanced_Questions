/*
(n=5)		i	midSp(<=2*(i-1)-1)
*			1	0
* *			2	1
*   *		3	3
*     *		4	5
* * * * *	5	(if i<n)

*/

import java.util.*;

public class L
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of rows-");
		int n=sc.nextInt();

		for(int i=1;i<=n;i++)
		{
			if(i<n)
			{
				System.out.print("*");


				for(int midSp=1;midSp<=(2*(i-1)-1);midSp++)
					System.out.print(" ");

				if(i!=1)
					System.out.print("*");

				System.out.println(" ");
			}
			else
			{
				for(int j=1;j<=n;j++)
					System.out.print("* ");
			}
		}
	}
}