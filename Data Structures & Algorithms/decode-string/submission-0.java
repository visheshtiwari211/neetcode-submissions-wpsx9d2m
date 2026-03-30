class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String temp = "";
                while (!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                String num = "";
                while (!stack.isEmpty()) {
                    String top = stack.peek();
                    char c = top.charAt(0);

                    if (c >= '0' && c <= '9') {
                        num = stack.pop() + num;
                    } else {
                        break;
                    }
                }

                int repeat = Integer.parseInt(num);
                String expanded = "";
                for (int j = 0; j < repeat; j++) {
                    expanded += temp;
                }

                stack.push(expanded);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        String result = "";

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}