import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[volumn];
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
		        
		    System.out.println(canPartition(arr));
		}
		catch(Exception e) {
		    return;
		}
	}
}