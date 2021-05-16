/*
Allocate minimum number of pages
Difficulty Level : Hard

Given number of pages in n different books and m students. The books are arranged in ascending order of number of pages. Every
student is assigned to read some consecutive books. The task is to assign books in such a way that the maximum number of pages
assigned to a student is minimum.
Example :


Input : pages[] = {12, 34, 67, 90}
        m = 2
Output : 113
Explanation:
There are 2 number of students. Books can be distributed
in following fashion :
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student
      2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student
      2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student
      1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.

*/

/*
Approach as per gfg-->
The idea is to use Binary Search. We fix a value for the number of pages as mid of current minimum and maximum. We initialize
minimum and maximum as max-of-all-pages and sum-of-all-pages respectively. If a current mid can be a solution, then we search on
the lower half, else we search in higher half.
Now the question arises, how to check if a mid value is feasible or not? Basically, we need to check if we can assign pages to
all students in a way that the maximum number doesn’t exceed current value. To do this, we sequentially assign pages to every
student while the current number of assigned pages doesn’t exceed the value. In this process, if the number of students becomes
more than m, then the solution is not feasible. Else feasible.
*/

/*
Dry run of this approach-->

arr[] : 10 20 30 40
k=2
posiible pairs: {10},{20,30,40} ; {10,20},{30,40} ; {10,20,30},{40}
their sums    : {10,90}           {30,70}           {60,40}
max pages     : 90                70                60
min           : 60 <--answer

_______>___<___<_________________
|      | |||   |                |			start=40, end=100, mid=70 ; s1=10,20,30  s2=40 #=k res=70 {move left}
40     55|||   70               100			start=40, end=70,  mid=55 ; s1=10,20  s2=30  s3=40 #>k  {move right}
         |||						start=55, end=70,  mid=62 ; s1=10,20,30  s2=40 #=k res=62 {move left}
        58|62						start=55, end=62,  mid=58 ; s1=10,20  s2=30  s3=40  #>k  {move right}
          60						start=58, end=62,  mid=60 ; s1=10,20,30  s2=40 #=k res=60 <--answer
*/
public class AllocateMinimumNumberOfPages
{
	public static boolean isValid(int arr[],int k,int max)
	{
		int n=arr.length;
		int student=1;
		int sum=0;

		for(int i=0;i<n;i++)
		{
			sum+=arr[i];

			if(sum>max)
			{
				student++;
				sum=arr[i];
			}
			if(student>k)
				return false;
		}

		return true;
	}
	public static int minPages(int arr[], int k)
	{
		if(arr.length<k)
			return Integer.MAX_VALUE;//since every student should get atleast one book and here no. of students > no. of books

		int n=arr.length;

		int max=arr[0];

		for(int i=0;i<n;i++)
		{
			if(max<arr[i])
				max=arr[i];
		}

		int sum=0;

		for(int i=0;i<n;i++)
			sum+=arr[i];

		int start= max, end=sum;
		int res= Integer.MAX_VALUE;

		while(start<=end)
		{
			int mid=start + (end-start)/2;

			if(isValid(arr,k,mid))
			{
				res = Math.min(res,mid);
				end=mid-1;
			}
			else
				start=mid+1;
		}
		return res;
	}
	public static void main(String args[])
	{
		int arr[] = {12, 34, 67, 90};
		System.out.println(minPages(arr,2));
	}
}
