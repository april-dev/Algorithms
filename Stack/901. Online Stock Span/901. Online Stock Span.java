class StockSpanner {
    //List<Integer> stock;
    //List<Integer> smaller;
    Stack<int[]> stack;
    public StockSpanner() {
        //stock = new ArrayList<>();
        //smaller = new ArrayList<>();
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >=stack.peek()[0]){
            int[] cur = stack.pop();
            count += cur[1];
        }
        stack.add(new int[]{price, count});
        return count;
    }
}
