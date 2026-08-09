class Solution {
    public boolean isValid(String s) {
        Set<Character> open = new HashSet<>();
        open.add('(');
        open.add('{');
        open.add('[');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (open.contains(c)){
                stack.add(c);
            }else{
                if(stack.isEmpty()) return false;
                if(c == ')' && stack.peek() != '(') return false;
                if(c == '}' && stack.peek() != '{') return false;
                if(c == ']' && stack.peek() != '[') return false;
                
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
