
import java.util.Scanner;

//	*  *  *    *  *  * 0  for part 1 n=3			for part 3
//	*  *          *  * 1	i  j1	sp	j2			i	j1	sp	j2
//	*                * 2	0	3	0	3			0	1	12	1
//					   0	1	2	6	2			1	2	6	2
//					   1	2	1	12	1			2	3	0	3
//	*                * 0  for part 2 print (n-1)
//	*  *          *  * 1  blank lines...
//	*  *  *    *  *  * 2

public class H {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of rows =");
		int n = sc.nextInt();
		for(int i=0;i<n;i++)//part1
		{
			for(int j1=1;j1<=n-i;j1++)
				System.out.print("*  ");
			for(int sp=1;sp<=6*i;sp++)
				System.out.print(" ");
			for(int j2=1;j2<=n-i;j2++)
				System.out.print("  *");

			System.out.println();
		}

		for(int i=0;i<n-1;i++)//part2
			System.out.println();


		for(int i=0;i<n;i++)
		{
			for(int j1=0;j1<i+1;j1++)
				System.out.print("*  ");
			for(int sp=0;sp<6*(n-i-1);sp++)
				System.out.print(" ");
			for(int j2=0;j2<i+1;j2++)
				System.out.print("  *");

			System.out.println();
		}

	}
}
