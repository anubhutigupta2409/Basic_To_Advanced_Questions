//Two Pointer Algorithm
//A question to Demonstrate Two pointer Algorithm
//Taken from GeeksForGeeks
/* in this question you will be given an array, and you have to tell whether it consists of atleast one triplet whose sum is
zero, input will be in the form-
2	//no. of testcases
5	//no. of elements in the array
1 2 -3 4 5	// contents of array
3	//no. of elements
1 2 3	//contents of the array
output-
1	//triplet found
0	//Not Found
Three Sum Problem */

import java.util.*;

public class ThreeSum{
	public static void main(String args[]){
			Scanner sc= new Scanner(System.in);
			int t= sc.nextInt();//testcases
			while(t-->0){
				int n= sc.nextInt();
				int a[]= new int[n];
				for(int i=0;i<n;i++)
					a[i]=sc.nextInt();
				if(findTriplet(a,n))
					System.out.println("1");// output will be given after the input of each array
				else
					System.out.println("0");
				}
		}


public  static boolean findTriplet(int a[], int n)
{
	Arrays.sort(a); // As we want sorted array for this algorithm
	for(int i=0;i<n-2;/*As in the end the position of two pointers will be left*/i++)
		{ if(twoSum(a,-a[i],i+1))
			return true;
		}
	/* We are taking one element of the array and then checking whether we are checking ,if a pair exists
	along with which the number forms a sum==0*/
	 return false;
}
/*function two check if any "two elements combined" in the array are equal to the particular element given as argument.	*/
public static boolean twoSum(int a[],int x,int i){
		int j = a.length - 1;
		while(i<j)
		{
			if((a[i]+a[j])<x)
				i++;
			else if((a[i] +a[j])>x)
				j--;
			else
				return true;
		}
		return false;
	}

}