class Solution {
    List<String> l1 = new ArrayList();
    public List<String> generateParenthesis(int n) {
        genP("", 0, 0, n);
        return l1;
    }

    public void genP(String s, int oCnt, int cCnt, int n) {
        if(oCnt + cCnt == 2 * n) {
            l1.add(s);
            return;
        }

        if(oCnt < n) {
            genP(s + "(", oCnt + 1, cCnt, n);
        }
        if(cCnt < oCnt) {
            genP(s + ")", oCnt, cCnt + 1, n);
        }
        return;
    }
}
