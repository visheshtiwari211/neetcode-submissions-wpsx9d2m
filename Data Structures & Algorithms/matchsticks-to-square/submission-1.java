class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for(int x: matchsticks) {
            total += x;
        }

        if(total % 4 != 0) return false;
        return getS(matchsticks, 0, 0,0,0,0, total);
    }

    public boolean getS(int[] matchsticks, int i, int grp1, int grp2, int grp3, int grp4, int total) {
        if(grp1 > total/4 || grp2 > total/4 || grp3 > total/4 || grp4 > total/4) {
            return false;
        }
        if(grp1 == total/4 && grp2 == total/4 && grp3 == total/4 && grp4 == total/4 && i == matchsticks.length) {
            return true;
        }

        if(i >= matchsticks.length) {
            return false;
        }

        boolean f = getS(matchsticks, i + 1, grp1 + matchsticks[i], grp2, grp3, grp4, total); 
        if(f) return true;
        boolean s = getS(matchsticks, i + 1, grp1, grp2 + matchsticks[i], grp3, grp4, total);
        if(s) return true;
        boolean t = getS(matchsticks, i + 1, grp1, grp2, grp3 + matchsticks[i], grp4, total); 
        if(t) return true;
        boolean u = getS(matchsticks, i + 1, grp1, grp2, grp3, grp4 + matchsticks[i], total); 
        if(u) return true;
        return false;
    }
}