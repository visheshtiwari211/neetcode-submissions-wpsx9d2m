class StockSpanner {
    Stack<int[]> stocks;
    public StockSpanner() {
        stocks = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stocks.empty() && stocks.peek()[0] <= price) {
            span += stocks.peek()[1];
            stocks.pop();
        }
        stocks.add(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */