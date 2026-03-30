class Solution {
    List<List<String>> list = new ArrayList<>();
    List<String> part = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0,0,s);
        return list;
    }

    public void dfs(int j, int i, String s) {
        if(i >= s.length()) {
            if(i == j) {
                list.add(new ArrayList<>(part));
            }
            return;
        }

        if(isPali(s,j,i)) {
            part.add(s.substring(j, i+1));
            dfs(i+1, i+1, s);
            part.remove(part.size()-1);
        }
        dfs(j, i+1, s);
        return;
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
