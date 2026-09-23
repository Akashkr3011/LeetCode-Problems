class Solution {
    public int thirdMax(int[] nums) {
        long largest=Long.MIN_VALUE;
        long s_largest=Long.MIN_VALUE;
        long t_largest=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            long curr=nums[i];
            if(curr>largest){
                t_largest=s_largest;
                s_largest=largest;
                largest=curr;
            }
            else if(curr>s_largest && curr!=largest){
                t_largest=s_largest;
                s_largest=curr;
            }
            else if(curr>t_largest && curr!=largest && curr!=s_largest){
                t_largest=curr;
            }
        }
        if(t_largest==Long.MIN_VALUE){
            return (int)largest;
        }
        return (int)t_largest;
    }
}