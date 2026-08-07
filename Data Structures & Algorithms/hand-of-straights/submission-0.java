class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] count = new int[1001];
        for(int h : hand) count[h] ++;
        for(int i = 0; i < 1001; i ++){
            int groupEnd = i + groupSize;
            int mustGo = count[i];
            if(groupEnd >= 1001) continue;
            for(int j = i; j < groupEnd; j ++){
                count[j] -= mustGo;
                if(count[j] < 0) return false; 
            }
        }
        for(int i = 0; i < 1001; i ++){
            if(count[i] < 0) return false;
        }
        return true;
    }
}
