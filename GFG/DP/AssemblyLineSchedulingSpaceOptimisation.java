public class AssemblyLineSchedulingSpaceOptimisation
{
public static int carAssembleTime(int a[][], int t[][],	int e[], int x[]) {
		
	//dp variables
      	int n = a[0].length;
      	
      	//adding entry times
      	int first = a[0][0] + e[0];
      	int second = a[1][0] + e[1];
      
      	//filling the dp arrays, where each cell
      	//denotes the minimum time to reach that station
      	//from all possible paths
      	for(int i=1;i<n;++i)
        {
		int straight = first + a[0][i];
          	int diagonal = second + t[1][i] + a[0][i];
          	int one = Math.min(straight, diagonal);
          
          	straight = second + a[1][i];
          	diagonal = first + t[0][i] + a[1][i];
          	int two = Math.min(straight, diagonal);
          
          	first = one;
          	second = two;
        }
      
      	//adding exit times
      	return Math.min(first+x[0] , second+x[1]);
	}
	
}