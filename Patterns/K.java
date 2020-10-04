/* (n=10)					i	sp<=2*(i-1)			j(i-(n-1))		j((n-1)-i)
                  0				10	18				-			-
                9 0 9				9	16				9-			-9
              8 9 0 9 8				8	14				8-9			9-8
            7 8 9 0 0 8 7			7	12				7-9			9-7
          6 7 8 9 0 9 8 7 6			6	10				6-9			9-6
        5 6 7 8 9 0 9 8 7 6 5			5	8				5-9			9-5
      4 5 6 7 8 9 0 9 8 7 6 5 4			4	6				4-9			9-4
    3 4 5 6 7 8 9 0 9 8 7 6 5 4 3 		3	4				3-9			9-3
  2 3 4 5 6 7 8 9 0 9 8 7 6 5 4 3 2		2	2				2-9			9-2
1 2 3 4 5 6 7 8 9 0 9 8 7 6 5 4 3 2 1		1	1				1-9			9-1

*/

import java.util.*;

public class K
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of rows-");
		int n= sc.nextInt();

		for(int i=n;i>=1;i--)
		{
			for(int sp=1;sp<=2*(i-1);sp++)
				System.out.print(" ");

			for(int j=i;j<=(n-1);j++)
				System.out.print(j+" ");

			System.out.print("0 ");

			for(int j=(n-1);j>=i;j--)
				System.out.print(j+" ");

			System.out.println();
		}
	}
}
