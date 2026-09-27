class Solution {

    String moveToParent = "../";
    String remain = "./";
    public int minOperations(String[] logs) {
        if(logs.length == 0){
            return 0;
        }
        
        Deque<String> stack = new ArrayDeque<>();

        for(String log : logs){
            if(!log.equals(moveToParent) && !log.equals(remain)){
                stack.push(log);
            }else if(!log.equals(remain) && stack.size() > 0){
                stack.pop();
            }
        }
        return stack.size();
    }
}