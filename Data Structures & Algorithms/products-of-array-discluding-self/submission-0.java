class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProd = 1, zeroCount = 0;
        
        for(int num: nums) {
            if(num != 0){
                totalProd = totalProd * num;
            } else {
                zeroCount++;
            }
        }
        int[] prod = new int[nums.length];
        int i = 0;

        while(i<prod.length) {
            if(zeroCount >= 2) {
                prod[i] = 0;
            } else if(zeroCount == 1) {
                if(nums[i] == 0) {
                    prod[i] = totalProd;
                } else {
                    prod[i] = 0;
                }
            } else {
                prod[i] = totalProd/nums[i];
            }
            i++;
        }

        return prod;
    }
}  
