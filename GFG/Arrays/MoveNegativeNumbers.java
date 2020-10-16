import java.io.*;
import java.util.*;

public class MoveNegativeNumbers {

    public static void solution(int a[])
    {
        int j=0,temp;
		        for(int i=0;i<a.length;i++)
		        {
		            if(a[i]<0)
		            {
		                if(i!=j)
		                {
		                    temp=a[i];
		                    a[i]=a[j];
		                    a[j]=temp;
		                }
		                j++;
		            }
        }

        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
		    a[i]=sc.nextInt();
		solution(a);
	}
}