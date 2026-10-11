class NumArray {
    int nums[];

    public NumArray(int[] nums) {
        this.nums=nums;
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return left==0?nums[right]:nums[right]-nums[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */