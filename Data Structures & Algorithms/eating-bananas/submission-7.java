class Solution {
    public int minEatingSpeed(int[] piles, int h) {
           int n = piles.length;
           int max = Integer.MIN_VALUE;
           for(int x: piles) {
            max = Math.max(max, x);
           }

           int l = 1, r= max, speed  = 0;
           while(l <= r) {
            int mid = (l + r)/2;
            if(canFinish(mid, h, n, piles)) {
                speed = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
           } 

          return speed;
    }

    public boolean canFinish(int speed, int h, int n, int[] piles) {
        int i = 0, time = 0;
        while(i < n) {
            time += (int) Math.ceil((double)piles[i] / speed);
            i++;
        }
        if(time <= h) return true;
        return false;
    }
}
