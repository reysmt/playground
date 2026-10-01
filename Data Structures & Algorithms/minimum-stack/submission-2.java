class MinStack {
    Deque<Long> stack;
    long min = 0;
    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            min = val;
            return;
        }

        stack.push(val - min);
        min = Math.min(min, val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        long pop = stack.pop();

        if(pop < 0) min = min - pop;
    }
    
    public int top() {
        return stack.peek() > 0 ? (int)(stack.peek() + min) : (int)min;
    }
    
    public int getMin() {
        return (int) min;
    }
}
