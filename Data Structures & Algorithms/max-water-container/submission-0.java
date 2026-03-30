class Solution {
    public int maxArea(int[] heights) {
        int max = 0, i=0, j = heights.length - 1;

        while(i < j) {
            int area = (j-i) * Math.min(heights[i], heights[j]);
            max = Math.max(area, max);
            if(heights[i]<heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
