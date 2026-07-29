class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target))
            return 0;
        int jump = 1;
        Queue<String> q = new LinkedList<>();
        q.add(start);
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        if(set.contains(start)) return -1;

        int size = q.size();
        while (!q.isEmpty()) {
            String s = q.poll();
            size--;
            for(int i = 0; i<4; i++) {
                Character c = s.charAt(i);
                char resultAdd = (char) (((c - '0' + 1) % 10) + '0');
                char resultDec = (char) (((c - '0' - 1 + 10) % 10) + '0');
                String nextAdd = replaceCharAt(s, i, resultAdd);
                if(nextAdd.equals(target)) return jump;
                if (!set.contains(nextAdd)) {
                    q.add(nextAdd);
                    set.add(nextAdd);
                }

                String nextDec = replaceCharAt(s,i,resultDec);

                if(nextDec.equals(target)) return jump;
                if (!set.contains(nextDec)) {
                    q.add(nextDec);
                    set.add(nextDec);
                }
            }
            if(size == 0) {
                size = q.size();
                jump++;
            }
        }

        return -1;
    }

    private String replaceCharAt(String s, int index, char newChar) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index, newChar);
        return sb.toString();
    }
}