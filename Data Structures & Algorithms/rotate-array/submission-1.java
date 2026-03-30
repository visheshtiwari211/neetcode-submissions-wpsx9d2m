class Solution {
    public void rotate(int[] nums, int k) {
        int l = k;
        if(l > nums.length) l = l%nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, l - 1);
        reverseArray(nums, l, nums.length - 1);
    }

    public void reverseArray(int[] nums, int i , int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}