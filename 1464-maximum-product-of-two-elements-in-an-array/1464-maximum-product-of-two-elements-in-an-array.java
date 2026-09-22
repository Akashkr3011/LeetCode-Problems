class Solution {
    public int maxProduct(int[] nums) {
        int largest = -1;
        int S_largest = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                S_largest = largest;
                largest = nums[i];
            } else if (nums[i] > S_largest) {
                S_largest = nums[i];
            }
        }

        return (largest - 1) * (S_largest - 1);
    }
}