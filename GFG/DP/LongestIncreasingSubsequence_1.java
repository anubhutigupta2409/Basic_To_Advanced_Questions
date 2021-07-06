class LongestIncreasingSubsequence_1 
{
    static int ind(int tail[], int low, int high, int key)
    {
        while(high-low > 1)
        {
            int mid = low + (high-low)/2;
            
            if(tail[mid] >= key)
                high = mid;//as we have to replace it with the smallest element greater to the key
            
            else
                low = mid;
        }
        
        return high;
    }
    
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
            if(a[i]<tail[0])
                tail[0] = a[i];//new smaller element, as it has potential to start a new sequence, which can be larger
                
            //if greater than the current element in dp then simply add
            if(tail[len-1] < a[i])
                tail[len++] = a[i];
                
            //else replace it with the similar or the next greater element
            else
                tail[ind(tail, -1, len-1, a[i])] = a[i];
        }
        
        return len;
    }
} 