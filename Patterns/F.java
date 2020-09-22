
import java.util.Scanner;


//            *              n=5   i	sp		J		i=1;i<=n
//          *   *  				   1	8		1		sp=o;sp<=2*(n-i)
//        *   *   *   	   		   2    6       2		j=1;j<=i
//      *   *   *   *			   3	4       3
//    *   *   *   *    *		   4    2       4
// 								   5    0       5
public class F {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of rows=");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int sp=0;sp<=(n-i);sp++)
			{
				System.out.print("  ");
			}

			for(int j=1;j<=i;j++)
			{
				System.out.print("*   ");
			}
			System.out.println();
		}

	}

}
