class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20002];
        for(int num : nums){
            count[num + 10000] ++;
        }
        int c = 0;
        for(int i = 20001; i >= 0; i --){
            if(count[i] > 0) c += count[i];
            if(c >= k) return i - 10000;
        }
        return -1;
    }
}
