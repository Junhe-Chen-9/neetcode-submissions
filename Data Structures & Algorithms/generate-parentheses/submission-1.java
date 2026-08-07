class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String curr, int open, int close, int n) {
        // Base case: if the string length is 2 * n, add to result
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }

        // We can add an opening bracket if we haven't used up all n of them
        if (open < n) {
            backtrack(res, curr + "(", open + 1, close, n);
        }

        // We can add a closing bracket if it won't exceed the number of opening brackets
        if (close < open) {
            backtrack(res, curr + ")", open, close + 1, n);
        }
    }
}