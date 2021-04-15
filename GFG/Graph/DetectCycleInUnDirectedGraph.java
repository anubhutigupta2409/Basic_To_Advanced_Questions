/*
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not.
 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 

Constraints:
1 = V, E = 105
*/

class DetectCycleInUnDirectedGraph
{
    private boolean isCycleHelper(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[], int parent)
    {
        visited[v] = true;
        
        ArrayList<Integer> x = adj.get(v);
        Iterator<Integer> it = adj.get(v).iterator();
        
        Integer i;
        
        while(it.hasNext())
        {
            i = it.next();
            //if this neighbour is not visited check for all it's neighbours
            if(!visited[i])
                if(isCycleHelper(i,adj,visited,v))
                    return true;
            
            //if it's visited and not the parent of current vertex, then cycle
            //is there
            else if(i != parent)
                return true;
                    
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean visited[] = new boolean[V];
        
        for (int i = 0; i < V; i++)
            visited[i] = false;
            
        for(int i=0;i<V;i++)
            if(!visited[i])
                if(isCycleHelper(i,adj,visited,-1))
                    return true;
                
        return false;
    }
}