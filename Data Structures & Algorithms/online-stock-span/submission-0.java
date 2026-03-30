class StockSpanner {
    List<Integer> stocks;
    public StockSpanner() {
        stocks = new ArrayList<>();
    }
    
    public int next(int price) {
        int span = 1;
        for(int i = stocks.size() - 1; i >=0; i--) {
            int prev =stocks.get(i);
            if(prev <= price) {
                span++;
            } else {
                break;
            }
        }
        stocks.add(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */