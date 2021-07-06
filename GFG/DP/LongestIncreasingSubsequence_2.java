class LongestIncreasingSubsequence_2 
{
    
    
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        //the ith index store the last element of the valid subsequence of length i+1
        int tail[] = new int[size];
        int len;
        
        tail[0] = a[0];
        len=1;//it's 1 now
        
        for(int i=1;i<size;i++)
        {
            //if greater than the current element in dp then simply add
            if(tail[len-1] < a[i])
                tail[len++] = a[i];
                
            //else replace it with the similar or the next greater element
            else
            {
                int index = Arrays.binarySearch(tail, 0, len-1, a[i]);
                //if index is positive means same element is found, otherwise
                //it returns a negative index, which stores the index, where element 
                //should have been originally stored in the array, if it existed
                
                if(index<0)
                    index = -1*index - 1;
                    
                //replace
                tail[index] = a[i];
            }
        }
        
        return len;
    }
} 