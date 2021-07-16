/*
Convert to Roman No

Given an integer n, your task is to complete the function convertToRoman which prints the corresponding roman number of n. Various symbols and their values are given below.

I 1
V 5
X 10
L 50
C 100
D 500
M 1000



Example 1:

Input:
n = 5
Output: V


Example 2:

Input:
n = 3
Output: III


Your Task:
Complete the function convertToRoman() which takes an integer N as input parameter and returns the equivalent roman.



Expected Time Complexity: O(log10N)
Expected Auxiliary Space: O(log10N * 10)



Constraints:
1<=n<=3999


*/

class IntegerToRoman
{
    String convertToRoman(int n)
    {
	// Your code here

	    int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String sym[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	    String res = "";

	    for(int i=0;i<values.length;i++)
	    {
	        while(n>=values[i])
	        {
	            n-=values[i];
	            res+=sym[i];
	        }
	    }

	    return res;
    }
}