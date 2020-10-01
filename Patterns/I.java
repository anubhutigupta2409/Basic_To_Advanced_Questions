
import java.util.Scanner;
//                1				i	sp	j
//		1   2 				1	16	1
//            1   2   3				2	14	2
//	    1   2   3   4 			3	12	3
//	  1   2   3   4   5    			4	10	4
//	1   2   3   4   5   6			5	8	5
//    1   2   3   4   5   6   7			6	6	6
//  1   2   3   4   5   6   7   8  		7	4	7
//1   2   3   4   5   6   7   8   9		8	2	8
// 						9	0	9
public class I {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of rows=");
		int n= sc.nextInt();

		for(int i=1;i<=n;i++)
		{
			int var = 0;
			for(int sp=1;sp<=2*(n-i);sp++)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				var+=1;
				System.out.print(var+"   ");

			}

			System.out.println();

		}



}
}
