/*
Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. Your task is to complete all the functions, using stack data-Structure.


Example 1:

Input:
Stack: 18 19 29 15 16
Output: 15
Explanation:
The minimum element of the stack is 15.



Your Task:
Since this is a function problem, you don't need to take inputs. You just have to complete 5 functions, push() which takes the stack and an integer x as input and pushes it into the stack; pop() which takes the stack as input and pops out the topmost element from the stack; isEmpty() which takes the stack as input and returns true/false depending upon whether the stack is empty or not; isFull() which takes the stack and the size of the stack as input and returns true/false depending upon whether the stack is full or not (depending upon the
given size); getMin() which takes the stack as input and returns the minimum element of the stack.
Note: The output of the code will be the value returned by getMin() function.


Expected Time Complexity: O(N) for getMin, O(1) for remaining all 4 functions.
Expected Auxiliary Space: O(1) for all the 5 functions.


Constraints:
1 = N = 104
*/

/*
Approach-->

we maintain a minimum element for the stack and keep on updating it as sson as we push or pop a new element in our stack

push()
1.if the stack was empty, we make the newly added element = the minimum element
2.if newly pushed element is more or equal to the minimum element, the minEle remains same
3.if it less then, we push 2*newEle - minEle(previous) in the stack and update the minEle=newEle

pop()
1.if the popped element is greater than or equal to the popped element, nothing changes
2.if it less than that, we pop the minEle(previous) and update it as minEle = 2*minEle - (to be popped)

Observe-->
we do not push real elements in the stack, the exact minimum element is found in minEle only
*/

class SpecialStack{

    int minEle;//we maintain

	public void push(int a,Stack<Integer> s)
	{
	    //add code here.
	    if(isEmpty(s))
	    {
	        minEle = a;
	        s.push(a);
	        return;
	    }

	    if(a<minEle)
	    {
	        s.push(2*a-minEle);
	        minEle=a;
	    }

	    else
	        s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
        //add code here.
        if(isEmpty(s))
            return -1;

        Integer ele = s.pop();

        if(ele<minEle)
        {
            int temp=minEle;
            minEle = 2*minEle - ele;
            return temp;
        }

        else
            return ele;
	}
	public int min(Stack<Integer> s)
    {
        if(isEmpty(s))
            return -1;
        else
            return minEle;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        //add code here.
        Object arr[] = s.toArray();
        return (n == arr.length);
	}
	public boolean isEmpty(Stack<Integer>s)
    {
        //add code here.
        return s.empty();
	}
}