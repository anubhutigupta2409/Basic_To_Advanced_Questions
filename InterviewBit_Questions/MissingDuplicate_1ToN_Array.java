
import java.util.*;

public class MissingDuplicate_1ToN_Array
{
	public static void sol(int arr[])
	{
		int missing=-1, duplicate=-1;
		int n=arr.length;

		int i=0;

		while(i<n)
		{
			if(arr[i]!=arr[arr[i]-1])
			{
				int temp = arr[i];
				arr[i] = arr[arr[i]-1];
				arr[arr[i]-1] = temp;
			}
			else
				i++;
		}

		for(i=0;i<n;i++)
		{
			if(arr[i]!=i+1)
			{
			    missing=i+1;
			    duplicate=arr[i];
			    break;
			}
		}

		System.out.println("["+duplicate+" ,"+missing+"]");
	}

	public static void main(String args[])
	{
		int arr[] = {3,1,2,5,3};
	    sol(arr);

	}
}