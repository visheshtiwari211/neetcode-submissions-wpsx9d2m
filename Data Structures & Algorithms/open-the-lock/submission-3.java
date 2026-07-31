class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (start.equals(target))
            return 0;
        int startJump = 0;
        int targetJump = 0;
        Queue<String> startQueue = new LinkedList<>();
        Queue<String> targetQueue = new LinkedList<>();
        HashSet<String> deadendSet = new HashSet<>();
        for (String d : deadends) {
            deadendSet.add(d);
        }
        if (deadendSet.contains(start))
            return -1;

        startQueue.add(start);
        targetQueue.add(target);
        HashSet<String> startSet = new HashSet<>();
        HashSet<String> targetSet = new HashSet<>();
        startSet.add(start);
        targetSet.add(target);

        int startSize = startQueue.size();
        int targetSize = targetQueue.size();
        while (!startQueue.isEmpty() && !targetQueue.isEmpty()) {
            if (startQueue.size() <= targetQueue.size()) {
                startJump++;
                int size = startQueue.size();
                for (int j = 0; j < size; j++) {
                    String s = startQueue.poll();
                    for (int i = 0; i < 4; i++) {
                        char c = s.charAt(i);
                        char resultAdd = (char) (((c - '0' + 1) % 10) + '0');
                        char resultDec = (char) (((c - '0' - 1 + 10) % 10) + '0');
                        
                        String nextAdd = replaceCharAt(s, i, resultAdd);
                        if (targetSet.contains(nextAdd)) return startJump + targetJump;
                        if (!deadendSet.contains(nextAdd) && !startSet.contains(nextAdd)) {
                            startQueue.add(nextAdd);
                            startSet.add(nextAdd);
                        }

                        String nextDec = replaceCharAt(s, i, resultDec);
                        if (targetSet.contains(nextDec)) return startJump + targetJump;
                        if (!deadendSet.contains(nextDec) && !startSet.contains(nextDec)) {
                            startQueue.add(nextDec);
                            startSet.add(nextDec);
                        }
                    }
                }
            } else {
                targetJump++;
                int size = targetQueue.size();
                for (int j = 0; j < size; j++) {
                    String s = targetQueue.poll();
                    for (int i = 0; i < 4; i++) {
                        char c = s.charAt(i);
                        char resultAdd = (char) (((c - '0' + 1) % 10) + '0');
                        char resultDec = (char) (((c - '0' - 1 + 10) % 10) + '0');
                        
                        String nextAdd = replaceCharAt(s, i, resultAdd);
                        if (startSet.contains(nextAdd)) return startJump + targetJump;
                        if (!deadendSet.contains(nextAdd) && !targetSet.contains(nextAdd)) {
                            targetQueue.add(nextAdd);
                            targetSet.add(nextAdd);
                        }

                        String nextDec = replaceCharAt(s, i, resultDec);
                        if (startSet.contains(nextDec)) return startJump + targetJump;
                        if (!deadendSet.contains(nextDec) && !targetSet.contains(nextDec)) {
                            targetQueue.add(nextDec);
                            targetSet.add(nextDec);
                        }
                    }
                }
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