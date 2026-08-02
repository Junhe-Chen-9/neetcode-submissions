class Solution {
    public int maxProfit(int[] prices) {
        int buyingpoint = prices[0];
        int res = 0;
        for(int p : prices){
            buyingpoint = Math.min(p,buyingpoint);
            res = Math.max(res,p - buyingpoint);
        }
        return res;
    }
}
