class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],i);
        }

        int result[]=new int[nums1.length];
        Stack<Integer> stack=new Stack<>();

        for(int j=nums2.length-1;j>=0;j--){
            System.out.println(stack);
            if(map.containsKey(nums2[j])){
            while(!stack.isEmpty() && stack.peek()<nums2[j])
            stack.pop();
                if(!stack.isEmpty() && stack.peek()>nums2[j])
                result[map.get(nums2[j])]=stack.peek();
                else
                result[map.get(nums2[j])]=-1;
            }
            stack.push(nums2[j]);
        }
        return result;
    }
}