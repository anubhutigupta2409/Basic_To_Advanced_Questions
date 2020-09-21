
import java.util.Scanner;

//* * * * *			
//    * * * *						
//        * * *					
//            * *			
//                *			
//                				
public class E {

	public static void main(String[] args) {
		System.out.println("Enter the no. of rows");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i= 0 ; i<n ; i++)
		{
			for(int sp = 0 ; sp<2*i ; sp++)
			{
				System.out.print("  ");
			}
			for(int j=0 ; j<n-i ;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}
