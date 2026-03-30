class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int a: asteroids) {
            boolean destroyed = false;

            while(!stack.empty() && stack.peek() > 0 && a < 0) {
                if(Math.abs(a) > Math.abs(stack.peek())) {
                    stack.pop();
                } else if (Math.abs(a) == Math.abs(stack.peek())) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }


            if(!destroyed && (stack.empty() || !(stack.peek() > 0 && a < 0))) {
                stack.push(a);
            }

        }

        int[] array = new int[stack.size()];

        for(int i = array.length - 1; i >=0; i--) {
            array[i] = stack.pop();
        } 

        return array;
    }
}