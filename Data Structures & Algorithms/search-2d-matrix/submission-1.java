class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] p: matrix) {
            int start = 0, end = p.length - 1;
            if(target == p[start] || target == p[end]) {
                return true;
            }
            if(target > p[start] && target<p[end]) {
                while(start < end) {
                    int mid = start + (end-start)/2;
                    if(p[mid] == target) {
                        return true;
                    } else if(target > p[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }   
                }
            }
        }

        return false;
    }
}
