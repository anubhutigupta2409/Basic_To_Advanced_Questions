/*
from Leet Code
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        /*
        Approach-
        here we are using hashMap as we knw here we are to group the strings based on them being the anagrams of eachother
        and we knw the data structure which can grp together elements based on some criteria or a key is hashMap.
        here we make the key to be the sorted form of the string that make up the different anagrams
        */
        Map <String, List<String>> map= new HashMap<>();

        for(String s : strs)
        {
            char[] charArr= s.toCharArray();//converting to char array
            Arrays.sort(charArr);//sorting it
            String sorted = new String(charArr);//converting back to string

            //if the key doesnot exist in the hashMap already then we pass the key value pair in our map based on the following
            //<our current sorted key, and a newly created LinkedList of type string as the value>
            if(!map.containsKey(sorted))
                map.put(sorted, new LinkedList <String>());

            //if such a key exists then we add the value corresponding to this key
            //how does it make sure that it is a anagram???
            //since the 's' string we are passing as value is anagram form only , of the sorted key we just created above
            //in this loop
            map.get(sorted).add(s);
        }
        //converting it into LinkedList as the .values(), returns us a set
        return new LinkedList<>(map.values());
    }
}

public class GroupAnagrams
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the no. of strings you want to enter");
		int n=sc.nextInt();
		String strs[]=new String[n];
		for(int i=0;i<n;i++)
			strs[i]=sc.next();

		Solution solution=new Solution();
		System.out.println(solution.groupAnagrams(strs));

	}
}