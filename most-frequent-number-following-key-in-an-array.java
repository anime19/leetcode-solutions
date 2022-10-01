import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static int mostFrequent(int[] nums, int key) {
        int index=0;
        List<Integer> l = new ArrayList<Integer>();
        int ans=0, max=0;
        for(int i=0;i<nums.length-1;i++){
          if(nums[i]==key){
              l.add(nums[i+1]);
          }
        }
        
        int ar[]=new int[l.size()];
        for(int i =0;i<ar.length;i++)
            ar[i]=l.get(i);
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i:ar){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
         List<Integer> list = new LinkedList<Integer>(hm.keySet());
        
        Collections.sort(list, (a,b)-> hm.get(b)-hm.get(a));
        
        return list.get(0);
    }

	public static void main (String[] args) throws IOException
	{
		// your code goes here
		try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
            int key = Integer.parseInt(br.readLine().trim());
            int n = Integer.parseInt(br.readLine().trim());
            int larr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    for(int i=0; i<n; i++)
		        arr[i] = Integer.parseInt(inputLine[i]);
		        
		    System.out.println(mostFrequent(arr, key));
		}
		catch(Exception e) {
		    return;
		}
	}
}