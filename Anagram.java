//To check whether the given strings are anagram of eachother or not
/*for example ana and naa are anagrams of eachother, that is , two strings which have same no. of letters and all the letters
should repeat exactly the same number, as it has in one of them*/
import java.util.*;

public class Anagram{
	public static void main(String args[])
	{	Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two strings-");
		String a = sc.nextLine();
		String b = sc.nextLine();
		a=a.toLowerCase();//converting them to lower case
		b=b.toLowerCase();//we have used "=" symbol since strings are immutable
		boolean isAnagram = true;//using a boolean variable
		//the least check they should pass, is having same no. of letters
		if(a.length() != b.length())
			isAnagram= false;
		else
		{
		int al[] = new int[256];//since there are only 256 characters possible
		for(char c : a.toCharArray()){
			int index=(int) c;
			al[index]++;//increasing the position if a certain character was present in string 1
			}
		for(char c : b.toCharArray()){
					int index=(int) c;
					al[index]--;//decreasing the position if a certain character was present in string 2
			}
		//since we have done increasing and decreasing respectively, the array al must have all zeroes
		//if the two input strings were anagrams
		for(int i=0;i<256;i++)
			{if(al[i]!=0)
				{isAnagram = false;
					break;
					}
				}
		}
		if(isAnagram)
			{
				System.out.println("Anagrams");}
		else{
			System.out.println("Not Anagrams");}


		}
	}