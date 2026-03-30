class Solution {
    public int minEatingSpeed(int[] piles, int h) {
            int max = Integer.MIN_VALUE;
            for(int p: piles) {
                max  = Math.max(p, max);
            }

            int left = 1;
            int result = max;

            while(left<=max) {
                int mid = left + (max-left) /2;
                int totalHr = 0;
                for(int p: piles) {
                    totalHr += (int) Math.ceil((double)p/mid);
                }
                if(totalHr<=h) {
                    result = mid;
                    max = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return result;
        }
}
