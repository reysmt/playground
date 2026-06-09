class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parentheses = new HashMap<Character,Character>();
        parentheses.put(')','(');
        parentheses.put(']','[');
        parentheses.put('}','{');
        Deque<Character> result = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(parentheses.containsKey(s.charAt(i))){
                if(!result.isEmpty() && result.peek() 
                    == parentheses.get(s.charAt(i))){
                    result.pop();
                }else {
                    return false;
                }
            }else {
                result.push(s.charAt(i));
            }
        }
        return result.isEmpty();
    }
}
