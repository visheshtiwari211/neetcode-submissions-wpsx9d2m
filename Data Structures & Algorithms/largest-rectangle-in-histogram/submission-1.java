class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        int[] leftMin = new int[n], rightMin = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()){
                st.push(i);
                leftMin[i] = 0;
            } else {
                leftMin[i] = st.peek() + 1;
                st.push(i);
            } 
        }
        while(!st.empty()) st.pop();
        for(int i = n-1; i >= 0; i--) {
            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if(st.empty()){
                st.push(i);
                rightMin[i] = n-1;
            } else {
                rightMin[i] = st.peek() - 1;
                st.push(i);
            } 
        }

        for(int i = 0; i < n; i++) {
            int area = (rightMin[i] - leftMin[i] + 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
