/*
Given a string S. The task is to print all permutations of a given string.



Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6
forms as ABC, ACB, BAC, BCA, CAB and CBA .
Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS
BASG BGAS BGSA BSAG BSGA GABS GASB
GBAS GBSA GSAB GSBA SABG SAGB SBAG
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.


Your Task:
You don't need to read input or print anything. Your task is to complete the function find_permutaion() which takes the string S as input parameter and returns a vector of string in lexicographical order.



Expected Time Complexity: O(n! * n)

Expected Space Complexity: O(n)



Constraints:
1 <= length of string <= 5
*/

class AllPermutationsOfString {

    List<String> res = new ArrayList<String>();

    public String interchange(String s, int a, int b)
    {
        char arr[] = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return String.valueOf(arr);

    }

    public void find_permutation(String s, int l, int r)
    {


        if(l==r)
        {
            res.add(s);

            return;
        }

        for(int i=l;i<=r;i++)
        {
            s=interchange(s,l,i);
            find_permutation(s,l+1,r);
            s=interchange(s,l,i);
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        find_permutation(S,0,S.length()-1);
        Collections.sort(res);
        return res;
    }
}