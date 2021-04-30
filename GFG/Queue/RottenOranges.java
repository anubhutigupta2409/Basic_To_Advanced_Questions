/*

Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:


0: Empty cell

1: Cells have fresh oranges

2: Cells have rotten oranges

Determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index [i,j] can rot other
fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right). If it is impossible to rot every orange
then simply return -1.




Examples:


Input:  arr[][C] = { {2, 1, 0, 2, 1},

                     {1, 0, 1, 2, 1},

                     {1, 0, 0, 2, 1}};

Output:
All oranges can become rotten in 2-time frames.

Explanation:
At 0th time frame:

 {2, 1, 0, 2, 1}

 {1, 0, 1, 2, 1}

 {1, 0, 0, 2, 1}



At 1st time frame:

 {2, 2, 0, 2, 2}

 {2, 0, 2, 2, 2}

 {1, 0, 0, 2, 2}



At 2nd time frame:

 {2, 2, 0, 2, 2}

 {2, 0, 2, 2, 2}

 {2, 0, 0, 2, 2}





Input:  arr[][C] = { {2, 1, 0, 2, 1},

                     {0, 0, 1, 2, 1},

                     {1, 0, 0, 2, 1}};

Output:
All oranges cannot be rotten.

Explanation:
At 0th time frame:

{2, 1, 0, 2, 1}

{0, 0, 1, 2, 1}

{1, 0, 0, 2, 1}



At 1st time frame:

{2, 2, 0, 2, 2}

{0, 0, 2, 2, 2}

{1, 0, 0, 2, 2}



At 2nd time frame:

{2, 2, 0, 2, 2}

{0, 0, 2, 2, 2}

{1, 0, 0, 2, 2}

...

The 1 at the bottom left corner of the matrix is never rotten.
*/

class RottenOranges
{
    //class to store i,j of an orange as an element in the queue
    class Orange
    {
        int x=0;
        int y=0;

        public Orange(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    boolean isValid(int i, int j, int[][] grid)
    {
        return (i>=0 && i<grid.length && j>=0 && j<grid[0].length);
    }

    //to check if we encountered a delimiter
    boolean isDelim(Orange o)
    {
        return (o.x==-1 && o.y==-1);
    }

    //to check if any fresh orange is left
    boolean isFresh(int grid[][])
    {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j] == 1)
                    return true;

        return false;
    }
    public int orangesRotting(int[][] grid)
    {
        // Code here
        Queue<Orange> q = new LinkedList<>();
        Orange o;
        int ans=0;

        int r = grid.length , c = grid[0].length;

        //add all rotten oranges
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(grid[i][j]==2)
                    q.add(new Orange(i,j));

        //add a delimiter to distinguish old rotten oranges
        q.add(new Orange(-1,-1));

        //rot all the adjacent oranges by removing one orange at a time
        //from the queue

        while(!q.isEmpty())
        {
            boolean flag= false;//will make it true if we rot an orange

            while(!isDelim(q.peek()))
            {
                o = q.peek();

                //right
                if(isValid(o.x+1 , o.y, grid) && grid[o.x+1][o.y] == 1)
                {
                    if(!flag)
                    {
                        ans++;//if the first one to get rot in this time frame
                        flag=true;
                    }

                    //rot it
                    grid[o.x+1][o.y] = 2;

                    //push into the queue
                    q.add(new Orange(o.x+1,o.y));
                }

                //left
                if(isValid(o.x-1 , o.y, grid) && grid[o.x-1][o.y] == 1)
                {
                    if(!flag)
                    {
                        ans++;//if the first one to get rot in this time frame
                        flag=true;
                    }

                    //rot it
                    grid[o.x-1][o.y] = 2;

                    //push into the queue
                    q.add(new Orange(o.x-1,o.y));
                }

                //top
                if(isValid(o.x , o.y+1, grid) && grid[o.x][o.y+1] == 1)
                {
                    if(!flag)
                    {
                        ans++;//if the first one to get rot in this time frame
                        flag=true;
                    }

                    //rot it
                    grid[o.x][o.y+1] = 2;

                    //push into the queue
                    q.add(new Orange(o.x,o.y+1));
                }

                //bottom
                if(isValid(o.x , o.y-1, grid) && grid[o.x][o.y-1] == 1)
                {
                    if(!flag)
                    {
                        ans++;//if the first one to get rot in this time frame
                        flag=true;
                    }

                    //rot it
                    grid[o.x][o.y-1] = 2;

                    //push into the queue
                    q.add(new Orange(o.x,o.y-1));
                }

                q.poll();//remove that rotten orange
            }

            q.poll();//remove the delimiter

            //if new lot of rotten oranges was added, add a new delimiter
            if(!q.isEmpty())
                q.add(new Orange(-1,-1));

        }

        //if any fresh oranges still left then the entire grid can't be rot
        if(isFresh(grid))
            return -1;

        return ans;
    }
}