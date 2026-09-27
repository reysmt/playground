class Solution {

    String moveToParent = "../";
    String remain = "./";
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();

        for(String log : logs){
            if(!log.equals(moveToParent) && !log.equals(remain)){
                stack.push(log);
            }else if(!log.equals(remain)){
                stack.pop();
            }
        }
        return stack.size();
    }
}