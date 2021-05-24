/*
Write a program to return minimum and maximum in an array, with minimum number of comparisons
*/
/*
Approachh->
[COMPARE IN PAIRS]
1.if n==even fix first two elements as min and max accordingly
2.if n==odd fix the first element as min and max both
3.continue by checking with the further pairs and update max and min accordingly
*/
class Pair
{
	int max;
	int min;
	public Pair()
	{
	}
	public Pair(int max, int min)
	{
		this.max=max;
		this.min=min;
	}
}
public class MaxMin3
{
	public static Pair maxMin(int arr[])
	{

		int n=arr.length;

		Pair maxmin = new Pair();
		int i;//index

		//even
		if(n%2==0)
		{
			if(arr[0]>arr[1])
			{
				maxmin.max=arr[0];
				maxmin.min=arr[1];
			}
			else
			{
				maxmin.max=arr[1];
				maxmin.min=arr[0];
			}

			i=2;
		}
		//odd
		else
		{
			maxmin.max=arr[0];
			maxmin.min=arr[0];

			i=1;
		}

		while(i<n-1/*not i<n as we are talking in pairs*/)
		{
			if(arr[i]>arr[i+1])
			{
				if(arr[i]>maxmin.max)
					maxmin.max=arr[i];
				if(arr[i+1]<maxmin.min)
					maxmin.min=arr[i+1];
			}
			else
			{
				if(arr[i+1]>maxmin.max)
					maxmin.max=arr[i+1];
				if(arr[i]<maxmin.min)
					maxmin.min=arr[i];
			}

			i+=2;
		}

        return maxmin;
	}
	public static void main(String args[])
	{
		int arr[] = {1000, 11, 445, 1, 330, 3000};
		Pair res= maxMin(arr);

		System.out.println("Max--> "+res.max+"\nMin--> "+res.min);
	}
}