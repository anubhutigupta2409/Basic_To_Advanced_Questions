//					sp(2*(n-i-1))	i(n-1)	j(2*i - 1)
// 1 0 1 0 1 0 1			0		4		7
//   1 0 1 0 1				2		3		5
//     1 0 1				4 		2		4
//       1 				6		1		1
// where n= 5  where at odd places = 1 and even places = 0

 import java.util.*;

public class C {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n");
		int n = sc.nextInt();

		for(int i=n-1;i>=1;i--)
			{	for(int sp=1;sp<=2*(n-1-i); sp++)
					System.out.print(" ");

				for(int j= 1;j<= 2*i - 1; j++)
					System.out.print((j%2==0) ? "0 " : "1 " );

				System.out.println();
			}


	}
}
