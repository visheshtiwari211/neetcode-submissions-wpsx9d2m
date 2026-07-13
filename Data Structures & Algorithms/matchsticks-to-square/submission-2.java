class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for(int x: matchsticks) {
            total += x;
        }

        if(total % 4 != 0) return false;
        int [] sums = {0, 0, 0, 0};
        return getS(matchsticks, 0, sums, total);
    }

    public boolean getS(int[] matchsticks, int i, int[] sums, int total) {
        for(int s : sums) {
            if(s > total/4) return false;
        }
        if(i == matchsticks.length) {
            for(int s : sums) {
             if(s != total/4) return false;
            }
            return true;
        }

        if(i >= matchsticks.length) {
            return false;
        }

        for(int j = 0; j < sums.length; j++) {
            if(sums[j] > total/4) return false;
            if(j > 0 && sums[j] == sums[j-1]) continue;
            sums[j] += matchsticks[i];
            boolean ans = getS(matchsticks, i + 1, sums, total);
            if(ans) return true;
            sums[j] -= matchsticks[i];
        }
        return false;
    }
}