class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(String operation : operations){
            if (operation.equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                res += newTop;
            }else if(operation.equals("D")){
                stack.push(2 * stack.peek());
                res += stack.peek();
            }else if(operation.equals("C")){
                res -= stack.pop();
            }else{
                stack.push(Integer.parseInt(operation));
                res += stack.peek();
            }
        }
        return res;
    }
}