class FindMaxSumSuchThatNoElementsAreConsecutive_Optimised
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        //here inc denotes the max Sum which is calculated by including the previous element
        //and exc denotes max sum excluding the previous element

        int inc = arr[0];
        int exc = 0;
        int temp;//will be needed

        /*
        Now the max sum including the current element would be exc+curr ele, as
        elements can't be adj. therefore, exc considered only.
        max sum excluding the current element would be max(exc,inc)
        */

        for(int i=1;i<n;i++)
        {
            temp = Math.max(inc,exc);//basically calculating new exc and storing as inc value will be changed

            inc = exc + arr[i];
            exc = temp;
        }

        return Math.max(inc,exc);
    }
}
/*
Time complexity--> O(n)
*/