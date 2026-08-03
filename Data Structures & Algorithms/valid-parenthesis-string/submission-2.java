class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }

            // More ')' than '(' is invalid at any point
            if (maxOpen < 0) return false;

            // minOpen cannot drop below 0
            if (minOpen < 0) minOpen = 0;
        }

        return minOpen == 0;
    }
}