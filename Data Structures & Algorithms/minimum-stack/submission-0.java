class MinStack {
    Stack<Integer> stack;
    List<Integer> list = new ArrayList<Integer>();
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(list.size() != 0) {
            if(val < list.get(list.size()- 1)) {
                list.add(val);
            } else {
                list.add(list.get(list.size()- 1));
            }
        } else {
            list.add(val);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.pop();
        list.remove(list.size()- 1);
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return list.get(list.size()- 1);
    }
}
