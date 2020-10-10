//matrix multiplication

import java.util.*;

public class MatrixMultiplication
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of rows and columns of both the matrices respectively-");
		int row1= sc.nextInt(), col1= sc.nextInt(), row2= sc.nextInt(), col2= sc.nextInt();
		//compatibility check
		while(row2 != col1)
		{
			System.out.println("Wrong input!, enter the values again");
			row1= sc.nextInt();
			col1= sc.nextInt();
			row2= sc.nextInt();
			col2= sc.nextInt();
		}
		int[][] a= new int[row1][col1], b= new int[row2][col2], c= new int[row1][col2];
		int i,j,k;
		System.out.println("Enter the contents of matrix 1");
		for(i=0;i<row1;i++)
			for(j=0;j<col1;j++)
				a[i][j]= sc.nextInt();

		System.out.println("Enter the contents of matrix 2");
		for(i=0;i<row2;i++)
			for(j=0;j<col2;j++)
				b[i][j]= sc.nextInt();
		//logic
		for(i=0;i<row1;i++)
			for(j=0;j<col2;j++)
				for(k=0;k<row2;k++)
					c[i][j] += a[i][k]*b[k][j];
		//printing
		System.out.println("Matrix First-");
		for(i=0;i<row1;i++)
			{ for(j=0;j<col1;j++)
				System.out.print(a[i][j]+" ");
			  System.out.println();
			}

		System.out.println("Matrix Second-");
		for(i=0;i<row2;i++)
			{ for(j=0;j<col2;j++)
				System.out.print(b[i][j]+" ");
			  System.out.println();
			}

		System.out.println("Resultant Matrix-");
		for(i=0;i<row1;i++)
			{ for(j=0;j<col2;j++)
			  	System.out.print(c[i][j]+" ");
			  System.out.println();
			}

	}
}