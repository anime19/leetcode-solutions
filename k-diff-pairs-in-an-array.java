import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        int res = 0;
        for (int x : cnt.keySet()) {
            if ((k > 0 && cnt.containsKey(x + k)) || (k == 0 && cnt.get(x) > 1)) {
                res++;
            }
        }
        return res;
    }

	public static void main (String[] args) throws IOException
	{
		// your code goes here
		try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
            int k = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());
            int larr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    for(int i=0; i<n; i++)
		        arr[i] = Integer.parseInt(inputLine[i]);
		        
		    System.out.println(mostFrequent(arr, k));
		}
		catch(Exception e) {
		    return;
		}
	}
}