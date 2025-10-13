class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i= nums.length-2; i>=0; i--) { // find peak index, index beyond which elements >nums[index] exist
            if(nums[i]<nums[i+1]) {
                index = i;
                break;
            }
        }
        if(index==-1) {
            reverseOrder(0,nums.length-1,nums);
            return;
        }

        for(int i=nums.length-1; i>=0; i--) { // swap peak index element wiht number just greater than 
            if(nums[i]>nums[index]) {
                int temp = nums[i];
                nums[i]= nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverseOrder(index+1, nums.length-1,nums); //since beyond index+1 we couldn't find num > that means it's sorted in desc order so we reverse it to make it smaller, we've already made the longes prefix mathc as greatest
        
    }
    public void reverseOrder(int l, int r, int []nums) {
        while(l<r) { 
            int temp = nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}
