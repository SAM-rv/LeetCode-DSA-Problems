class Solution {
    public int thirdMax(int[] nums) {

        long max[]=new long[3];
        java.util.Arrays.fill(max,Long.MIN_VALUE);
        boolean found=false;
        
        for(int n:nums){
            if(n>max[0]){
                max[2]=max[1];
                max[1]=max[0];
                max[0]=n;
            }
            else{
                if(n>max[1] && n!=max[0]){
                    max[2]=max[1];
                    max[1]=n;
                }else if(n>max[2] && n!=max[1] && n!=max[0]){
                    max[2]=n;
                }
            }
        }
        
        return max[2]!=Long.MIN_VALUE ? (int)max[2] : (int)max[0];
        
    }
}