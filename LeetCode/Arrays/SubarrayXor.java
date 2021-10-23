/*
Count the number of subarrays having a given XOR
Difficulty Level : Hard

Given an array of integers arr[] and a number m, count the number of subarrays having XOR of their elements as m.
Examples:

Input : arr[] = {4, 2, 2, 6, 4}, m = 6
Output : 4
Explanation : The subarrays having XOR of
              their elements as 6 are {4, 2},
              {4, 2, 2, 6, 4}, {2, 2, 6},
               and {6}

Input : arr[] = {5, 6, 7, 8, 9}, m = 5
Output : 2
Explanation : The subarrays having XOR of
              their elements as 5 are {5}
              and {5, 6, 7, 8, 9}
*/

/*
Approach as explained by GFG -->

1) Initialize ans as 0.
2) Compute xorArr, the prefix xor-sum array.
3) Create a map mp in which we store count of
   all prefixes with XOR as a particular value.
4) Traverse xorArr and for each element in xorArr
   (A) If m^xorArr[i] XOR exists in map, then
       there is another previous prefix with
       same XOR, i.e., there is a subarray ending
       at i with XOR equal to m. We add count of
       all such subarrays to result.
   (B) If xorArr[i] is equal to m, increment ans by 1.
   (C) Increment count of elements having XOR-sum
       xorArr[i] in map by 1.
5) Return ans.
*/

// Java Program to count all subarrays having
// XOR of elements as given value m with
// O(n) time complexity.
import java.util.*;

class SubarrayXor( {

	// Returns count of subarrays of arr with XOR
	// value equals to m
	static long subarrayXor(int arr[], int n, int m)
	{
		long ans = 0; // Initialize answer to be returned

		int xor=0;

      Map<Integer,Integer> map = new HashMap<Integer,Integer>();


      for(int i=0;i<n;i++)
      {
        	xor^=arr[i];

        	if(map.get(xor^m)!=null)
              ans+=map.get(xor^m);

        	if(xor==m)
              ans++;

        	map.put(xor,map.getOrDefault(xor,0)+1);
      }
		// Return total count of subarrays having XOR of
		// elements as given value m
		return ans;
	}

	// Driver code
	public static void main(String[] args)
	{
		int arr[] = { 4, 2, 2, 6, 4 };
		int n = arr.length;
		int m = 6;

		System.out.print(
			"Number of subarrays having given XOR is "
			+ subarrayXor(arr, n, m));
	}
}

// This code is contributed by PrinciRaj1992
