/*
Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

class Solution
{
    public List<Integer> findAnagrams(String s, String ptr) 
    {
        
        List<Integer> ans = new ArrayList<>();
        int k = ptr.length();
		
		int i=0,j=0;
		
		HashMap<Character,Integer> mp = new HashMap<>();
		
		for(int m=0;m<k;m++)
		{
		    char c = ptr.charAt(m);
		    
		    if(mp.containsKey(c))
		    {
		        mp.put(c,mp.get(c)+1);
		    }
		    else{
		    mp.put(c,1);
		    }
		}
		int count = mp.size();
	   // int ans = 0;
	    while(j<s.length())
	    {/*
        char x = txt.charAt(j); 
            if(map.containsKey(x))
            {
                map.put(x, map.get(x)-1);//decrement the frequency
                if(map.get(x) == 0)
                    count--;//as one whole character is eliminated
            }*/
	        char sc = s.charAt(j);
	        if(mp.containsKey(sc))
	        {
	            mp.put(sc,mp.get(sc)-1);
	            
	            if(mp.get(sc) == 0)
	            {
	                count--;
	            }
	        }
	        
	        
	         if(j-i+1==k)
	        {
	            if(count==0)
	            {
	                ans.add(i);
	                //System.out.println(s.substring(i,j+1));
	            }
	            
	            if(mp.containsKey(s.charAt(i)))
	            {
	                mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
	                
	                if(mp.get(s.charAt(i))==1)
	                {
	                    count++;
	                }
	            }
	            i++;
	           
	        }
	       
	         j++;
	        
	    }
        return ans;
    }
}
