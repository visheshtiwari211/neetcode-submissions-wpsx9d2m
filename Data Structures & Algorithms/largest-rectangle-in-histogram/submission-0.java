class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i < heights.length; i++) {
            int l = i, r = i;

            while(l>=0 && heights[l] >= heights[i]) {
                l--;
            }

            while(r<heights.length && heights[r] >= heights[i]) {
                r++;
            }
            l++;
            r--;
                int localArea = heights[i] * (r-l+1);
                maxArea = Math.max(localArea, maxArea);
        }

        return maxArea;
    }
}
