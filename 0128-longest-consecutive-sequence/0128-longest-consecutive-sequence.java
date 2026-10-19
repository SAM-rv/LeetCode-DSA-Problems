class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        return 0;
        Arrays.sort(nums);

        int maxCount=0;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
            continue;
            if(nums[i-1]==nums[i]-1)
            count++;
            else{
                maxCount=Math.max(count,maxCount);
                count=1;
            }
        }
        maxCount=Math.max(count,maxCount);
        return maxCount;
    }
}