class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        // monotonic stack
        // what we do here is a strickly decreasing stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i ++){
            int currTemp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < currTemp){
                // curr Temp is a warmer day to that previous inserted day
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            // now we have to append us in the stack
            stack.add(i);
        }
        return res;
    }
}
