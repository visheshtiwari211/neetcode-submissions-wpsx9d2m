class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] p: matrix) {
            for(int q: p) {
                if(q == target){
                    return true;
                }
            }
        }

        return false;
    }
}
