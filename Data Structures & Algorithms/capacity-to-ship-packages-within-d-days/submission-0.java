class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxWeight = Integer.MIN_VALUE;
        int sum = 0;
        for(int w: weights) {
            maxWeight = Math.max(w, maxWeight);
            sum += w;
        }

        int l = maxWeight, r = sum;
        int minWeight = l;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(canShipInNDays(weights, days, mid)) {
                minWeight = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minWeight;
    }

    public boolean canShipInNDays(int[] weights, int days, int maxCapacity) {
        int noOfDays = 0, totalWeight = 0;

        for(int w: weights) {
            if(totalWeight + w > maxCapacity) {
                noOfDays++;
                totalWeight = 0;
            }
            totalWeight += w;
        }
        if(totalWeight > 0) noOfDays++;

        if(noOfDays<= days) return true; else return false;
    }
}