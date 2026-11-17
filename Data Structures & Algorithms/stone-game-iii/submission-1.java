class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[] leadArr = new Integer[stoneValue.length];
        int lead = getLead(stoneValue, 0, leadArr);
        if (lead > 0)
            return "Alice";
        else if (lead == 0)
            return "Tie";
        else
            return "Bob";
    }

    public int getLead(int[] stoneValue, int i, Integer[] lead) {
        if (i >= stoneValue.length) {
            return 0;
        }
        if(lead[i] != null) return lead[i];

        int first = 0, second = 0;
        if (i + 1 < stoneValue.length) {
            first = stoneValue[i + 1];
        }

        if (i + 2 < stoneValue.length) {
            second = stoneValue[i + 2];
        }

        lead[i] = Math.max(stoneValue[i] - getLead(stoneValue, i + 1, lead),
            Math.max((stoneValue[i] + first) - getLead(stoneValue, i + 2, lead),
                (stoneValue[i] + first + second) - getLead(stoneValue, i + 3, lead)));

        return lead[i];
    }
}