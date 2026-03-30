class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] arr = new int[temp.length];
        for(int i = 0;i<temp.length; i++) {
            Integer t = temp[i], j = i;
            while(j < temp.length) {
                if(temp[j] > temp[i]) {
                    Integer diff = j - i;
                    arr[i] = diff;
                    break;
                }
                j++;
            }
        }

        return arr;
    }
}
