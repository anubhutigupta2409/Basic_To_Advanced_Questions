/*

size of the second linked list (L2). In the forth line are space separated values of the second linked list.

Output:
For each test case output will be an integer denoting the product of the two linked list.

User Task:
The task is to complete the function multiplyTwoLists() which should multiply the given two linked lists and return the result.

Constraints:
1 <= T <= 100
1 <= N, M <= 100

Example:
Input:
2
2
3 2
1
2
3
1 0 0
2
1 0

Output:
64
1000

Explanation:
Testcase 1: 32*2 = 64.

Testcase 2: 100*10 = 1000.

*/

class MultiplyTwoLL{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node first,Node second){
          //add code here.
         long  num1 = 0, num2 = 0, m=1000000007;
        // ( a + b) % c = ( ( a % c ) + ( b % c ) ) % c

    // Generate numbers from linked lists
    while (first != null || second != null)
    {
        if (first != null)
        {
            num1 = (((num1%m)*(10%m))%m + (first.data%m))%m;
            first = first.next;
        }
        if (second != null)
        {
            num2 = (((num2%m)*(10%m))%m + (second.data%m))%m;
            second = second.next;
        }
    }

    // Return multiplication of
    // two numbers
    return ((num1%m)*(num2%m))%m;

   }
}
