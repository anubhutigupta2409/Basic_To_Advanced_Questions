/*
Write a program to return minimum and maximum in an array.
*/
class Pair
{
	int max;
	int min;
	public Pair(int max, int min)
	{
		this.max=max;
		this.min=min;
	}
}
public class MaxMin
{
	public static Pair maxMin(int arr[])
	{
		int n=arr.length;

		//base case
		if(n==1)
			return new Pair(arr[0],arr[0]);

		Pair res= new Pair(arr[0],arr[1]);

		for(int i=2;i<n;i++)
		{
			if(arr[i]>res.max)
				res.max=arr[i];
			else if(arr[i]<res.min)
				res.min=arr[i];
		}

		return res;
	}
	public static void main(String args[])
	{
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		Pair res= maxMin(arr);

		System.out.println("Max--> "+res.max+"\nMin--> "+res.min);
	}
}