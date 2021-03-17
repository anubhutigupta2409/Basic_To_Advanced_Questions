/*
Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)

Approach-->

to check whether str2 is a rotation of str1 or not-->
1.we create a temp string where we store the concatenation of str1 and str1 (str1+str1)
2.then we check if str2 is a substring of temp or not
3.if yes, then str2 is a rotation of str1
*/

import java.util.*;


public class IsRotation
{

    static boolean isRotation(String str1, String str2)
    {
		//1.str1 and str2 must have same length
		//2.str2 should be substring of str1+str1

		//The indexOf() method returns the position of the first occurrence of specified character(s) in a string.

        return (str1.length() == str2.length()) &&
               ((str1 + str1).indexOf(str2) != -1);
    }


    public static void main (String[] args)
    {
        Scanner sc= new Scanner(System.in);

		System.out.println("Enter String 1-->");
		String str1=sc.next();

		System.out.println("Enter String 2-->");
		String str2=sc.next();

        if (isRotation(str1, str2))
            System.out.println("Strings are rotations of each other");
        else
            System.out.printf("Strings are not rotations of each other");
    }
}
