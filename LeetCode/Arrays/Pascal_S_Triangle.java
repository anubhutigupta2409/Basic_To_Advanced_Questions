/*
Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:




Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]


Constraints:

1 <= numRows <= 30
*/

class Pascal_S_Triangle {
    public List<List<Integer>> generate(int numRows) {

        //resultant
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre=null;

        for(int i=0;i<numRows;i++)
        {
            row = new ArrayList<Integer>();
            //no. of elements in a row == the number of row
            for(int j=0;j<=i;j++)
            {
                //forst and last elelment of the row is 1
                if(j==0 || j==i)
                    row.add(1);
                else
                    row.add (pre.get(j-1) + pre.get(j));//addition
            }

            pre = row;
            res.add(row);
        }

        return res;

    }
}