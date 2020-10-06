/*
(n=5)		i	sp(2*(n-i))	midSp(i-1)
        *	1	8			0
      * *	2	6			1
    *   *	3	4			3
  *     *	4	2			5
* * * * *	5	0			(i<n)

*/

import java.util.*;

public class M
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of rows");
		int n=sc.nextInt();

		for(int i=1;i<=n;i++)
		{
			for(int sp=1;sp<=2*(n-i);sp++)
				System.out.print(" ");

			if(i<n)
			{
				System.out.print("*");


				for(int midSp=1;midSp<=2*(i-1)-1;midSp++)
					System.out.print(" ");

				if(i!=1)
					System.out.print("*");

				System.out.println();
			}
			else
			{
				for(int j=1;j<=n;j++)
					System.out.print("* ");
			}
		}

	}
}