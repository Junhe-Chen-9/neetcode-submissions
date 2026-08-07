class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEatingSpeed = 0;
        for(int pile : piles) maxEatingSpeed = Math.max(maxEatingSpeed,pile);
        int left = 0, right = maxEatingSpeed;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(getTimeToFinish(piles,pivot) > h){
                // eating too slow 
                left = pivot + 1;
            }else{
                // eating too fast or just on time
                right = pivot - 1;
            }
        }
        // left now has the proper speed which will finish
        return left;
    }
    private int getTimeToFinish(int[] arr, int k){
        int res = 0;
        for(int n : arr){
            res += Math.ceil(n * 1.0 / k);
        }
        return res;
    }
}
