class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> par = new HashMap<Character,Character>();
        par.put('(',')');
        par.put('[',']');
        par.put('{','}');
        Deque<Character> result = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(par.containsKey(c)){
                result.push(c);
            } else {
                if(par.isEmpty()) {
                    return false;
                }

                char top = result.pop();

                if(par.get(top) != c) {
                    return false;
                }
            }
        }
        return result.isEmpty();
    }
}
