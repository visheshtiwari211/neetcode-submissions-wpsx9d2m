class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<position.length; i++) {
            map.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        float[] time = new float[position.length];

        for(int i = 0; i<position.length; i++) {
            time[i] = ((float)(target - position[i])/map.get(position[i]));
        }

        float maxTime = 0;
        int fleet = 0;
        for(int i = position.length - 1; i >= 0; i--) {
            if(time[i] > maxTime) {
                fleet++;
                maxTime = time[i];
            }
        }

        return fleet;
    }
}
