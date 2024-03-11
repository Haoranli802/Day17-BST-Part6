class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    public TreeNode helper(int[] nums, int start, int end){
        if(start >= end) return null;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = start; i < end; i++){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode mid = new TreeNode(max);
        mid.left = helper(nums, start, index);
        mid.right = helper(nums, index + 1, end);
        return mid;
    }

}
// O(N^2), O(N)
