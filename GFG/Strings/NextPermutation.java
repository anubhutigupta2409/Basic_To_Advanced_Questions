/*
Next Permutation 
Medium 
Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 = N = 10000


*/
class NextPermutation{
    static List<Integer> nextPermutation(int n, int arr[]){
        // code here
        
        List<Integer> res = new ArrayList<>();
        
        int i;
        for(i=n-1;i>=0;i--)
        {   if(i-1>=0)
                if(arr[i-1]<arr[i])
                    break;
        }
                
        if(!(i>=0))
        {
            Arrays.sort(arr);
            for(int x :arr)
                res.add(x);
            
            return res;
        }
        
        int ip = Integer.MAX_VALUE;//inversion point
        int pos=i-1;//position of inversion point
        
        for(int j=i;j<n;j++)
        {
            if(arr[j]>arr[i-1])
            {
                if(ip>arr[j])
                {
                    ip = arr[j];
                    pos = j;
                }
            }
        }
        
        //swap
        int temp = arr[pos];
        arr[pos] = arr[i-1];
        arr[i-1] = temp;
        
        //sort the rest from i to n
        Arrays.sort(arr,i,n);//n is exclusive
        
        for(int x :arr)
                res.add(x);
            
        return res;
    }
}