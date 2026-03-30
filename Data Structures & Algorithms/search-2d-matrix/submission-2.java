class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int size = matrix[0].length;
        int left = 0, right = matrix.length - 1;
        int rowIndex = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(target >= matrix[mid][0] && target <=matrix[mid][size - 1]) {
                rowIndex = mid;
                break;
            } else if(target > matrix[mid][size-1]){
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        if(rowIndex == Integer.MAX_VALUE) {
            return false;
        }

        int[] p = matrix[rowIndex];
        int start = 0, end = size - 1;
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

        return false;
    }
}
