import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int minimumCost(int[] cost) {

        int ans=-1, sum=0, i=cost.length-3;

        if(cost.length==2)
            return cost[0]+cost[1];
        
        if(cost.length==1)
            return cost[0];
        
        Arrays.sort(cost);

        if(cost.length==3)
            return cost[1]+cost[2];

      for(int c:cost)
          sum+=c;


        while(i>=0){
            sum-=cost[i];
            i-=3;
        }
        return sum;
    }

	public static void main (String[] args) throws IOException
	{
		// your code goes here
		try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
            int n = Integer.parseInt(br.readLine().trim());
            int larr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    for(int i=0; i<n; i++)
		        arr[i] = Integer.parseInt(inputLine[i]);
		        
		    System.out.println(minimumCost(arr));
		}
		catch(Exception e) {
		    return;
		}
	}
}