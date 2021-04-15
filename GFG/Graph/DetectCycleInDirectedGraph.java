/*
Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false.

Example,

Input: n = 4, e = 6
0 -> 1, 0 -> 2, 1 -> 2, 2 -> 0, 2 -> 3, 3 -> 3
Output: Yes


Approach-->
1. a cycle exists if there is a back edge (self-loop), or the child is connected back to it's parent via edge
2. dfs of a cyclic graph represents a tree
3. we make a recursion stack, to keep track of the current vertex
4. if a vertex which is unvisited and it connects the vertex in the recursion stack, it is a back edge and hence yes a cyclic graph

*/

import java.util.*;

class Graph
{
	private LinkedList<Integer> adj[];

	public Graph(int v)
	{
		adj = new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i] = new LinkedList<Integer>();
	}
	public void addEdge(int source, int destination)
	{
		adj[source].add(destination);
		adj[destination].add(source);
	}

	private boolean isCyclicHelper(int i/*current node*/, boolean recStack[], boolean visited[])
	{
		if(recStack[i])
			return true;//we reached a vertex in the recursion stack (self-loop)

		if(visited[i])
			return false;//we have already used this vertex and it didn't connect us to a vertex in the recusion stack

		visited[i] = true;
		recStack[i] = true;

		for(int neighbour : adj[i])
			if(isCyclicHelper(neighbour,recStack,visited))
				return true;//checking for it's children(parallel edge)

		recStack[i] = false;//it's no more our current vertex

		return false;
	}

	public boolean isCyclic(int V/*no. of vertices*/)
	{
		boolean recStack[] = new boolean[V];
		boolean visited[] = new boolean[V];

		//checking for all the verices one by one

		for(int i=0;i<V;i++)
			if(isCyclicHelper(i,recStack,visited))
				return true;


			return false;
	}
}
public class DetectCycleInDirectedGraph
{

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Add no. of vertces and edges-->");
		int vertex = sc.nextInt();
		int edge = sc.nextInt();

		Graph graph = new Graph(vertex);

		System.out.println("Enter "+edge+" edges (in form of source followed by destination)");

		for(int i=0;i<edge;i++)
		{
			int source = sc.nextInt();
			int destination = sc.nextInt();

			graph.addEdge(source, destination);
		}

		if(graph.isCyclic(vertex))
			System.out.println("Graph contains cycle");
		else
		    System.out.println("Graph doesn't "
                                    + "contain cycle");

	}
}