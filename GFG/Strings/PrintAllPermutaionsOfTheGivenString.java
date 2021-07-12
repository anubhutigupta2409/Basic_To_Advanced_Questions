/*
Permutations of a given string

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
class PrintAllPermutaionsOfTheGivenString{
    List<String> res = new ArrayList<>();

    void util(String s, int left, int right)
    {
        if(left==right)
        {
            if(res.contains(s))
                return;
            res.add(s);
            return;
        }

        for(int i=left;i<=right;i++)
        {
            s = swap(s,left,i);
            util(s,left+1,right);//smaller string
            s = swap(s,left,i);//backtracking
        }
    }
    String swap(String s, int i, int j)
    {
        char arr[] = s.toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
    public List<String> find_permutation(String s) {
        // Code here
        util(s,0,s.length()-1);

        Collections.sort(res);
        return res;
    }
}