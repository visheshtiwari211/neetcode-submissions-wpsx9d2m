class Solution {
      List<List<String>> l1 = new ArrayList();
      public List<List<String>> partition(String s) {
          getP(s, new ArrayList(), 0, 0);
          return l1;
      }

      public void getP(String s, List<String> l2, int start, int end) {
          if(start >= s.length()) {
              l1.add(new ArrayList(l2));
              return;
          }
          if(end >= s.length()) {
            return;
          }

          String s1 = s.substring(start, end + 1);
          String reverse = new StringBuilder(s1).reverse().toString();
          if(s1.equals(reverse)) {
              l2.add(s1);
              getP(s, l2, end + 1, end + 1);
              if(!l2.isEmpty()) l2.removeLast();
          }

          getP(s, l2, start, end + 1);
          return;
      }
  }