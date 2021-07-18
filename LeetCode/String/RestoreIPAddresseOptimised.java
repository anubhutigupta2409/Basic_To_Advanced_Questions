/*
Restore IP Addresses
Medium

Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.



Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


Constraints:

0 <= s.length <= 3000
s consists of digits only.
*/

class RestoreIPAddresseOptimised {
    public List<String> restoreIpAddresses(String s) {

        //result list
        List<String> res = new ArrayList<>();

        StringBuilder ip = new StringBuilder();//this is mutable unlike string class

        for(int a=1 ; a<4 ; a++)
        {
            for(int b=1 ; b<4 ;b++)
            {
                for(int c=1 ; c<4 ; c++)
                {
                    for(int d=1 ; d<4 ; d++)
                    {
                        if(a+b+c+d == s.length())
                        {
                            int n1 = Integer.parseInt(s.substring(0,a));
                            int n2 = Integer.parseInt(s.substring(a,a+b));
                            int n3 = Integer.parseInt(s.substring(a+b,a+b+c));
                            int n4 = Integer.parseInt(s.substring(a+b+c));//just beg index

                            if(n1<=255 && n2<=255 && n3<=255 && n4<=255)
                            {
                                ip.append(n1).append('.').append(n2).append('.')
                                .append(n3).append('.').append(n4) ;

                                if(ip.length() == s.length()+3)//as we added three .
                                    res.add(ip.toString());

                                ip.delete(0 , ip.length());
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}