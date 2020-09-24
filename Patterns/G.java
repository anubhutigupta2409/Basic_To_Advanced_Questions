
import java.util.Scanner;

//            *		n=5	i	{sp 3*(n-i)	j		i	sp 3*(i-n)	j((n-i+1)
//         *  *	 i<2n		1	12		1		6	3		4
//      *  *  *			2	9		2		7	6		3
//   *  *  *  *			3	6		3		8	9		2
//*  *  *  *  *			4	3		4		9	12		1
//   *  *  *  *			5	0		5} if(i<=n)
//      *  *  *
//         *  *
//            *
public class G {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows=");
		int n= sc.nextInt();
		for(int i=1;i<2*n;i++)
		{
			if(i<=n)
			{
				for(int sp=0;sp<=3*(n-i);sp++)
				{
					System.out.print(" ");
				}
				for(int j=1;j<=i;j++)
				{
					System.out.print("*  ");
				}
			}
			else
			{
				for( int sp= 0;sp<=3*(i-n);sp++)
				{
					System.out.print(" ");
				}
				for(int j= 1;j<=i-2*(i-n);j++)
				{
					System.out.print("*  ");
				}
			}
			System.out.println();
		}

	}

}
