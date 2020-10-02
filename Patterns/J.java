import java.util.*;

//            1				i	sp	0(zeroes)
//   	   2  0  2 			1	12	0
//	3  0  0  0  3			2	9	1
//   4  0  0  0  0  0  4		3	6	3
//5  0  0  0  0  0  0  0  5		4	3	5
//					5	0	7
//

public class J {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the no. of rows");
		int n= sc.nextInt();
		int varForZero=1;
		for(int i=1;i<=n;i++)
		{
			//printing spaces
			for(int sp=1;sp<=3*(n-i);sp++)

				System.out.print(" ");

			//printing the variable
			System.out.print(i+"  ");

			if(i==1)
			{	System.out.println();
				continue;
			}

			for(int z=1;z<= 2*varForZero-1;z++)

				System.out.print("0  ");

			varForZero++;

			System.out.print(i+"\n");




		}

	}

}
