class Solution {
    public int[] productExceptSelf(int[] nums) {
        // left sum 
        int[] leftSum = new int[nums.length];
        Arrays.fill(leftSum,1);
        for(int i = 0; i < nums.length; i ++){
            if (i == 0){
                leftSum[i] = nums[i];
            }else{
                leftSum[i] = leftSum[i - 1] * nums[i];
            }
            
        }
        int[] rightSum = new int[nums.length];
        for(int i = nums.length -1; i >= 0; i --){
            if (i == nums.length -1){
                rightSum[i] = nums[i];
            }else{
                
                rightSum[i] = rightSum[i + 1] * nums[i];
                // System.out.println(rightSum[i]);
            }
        } 

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            int left = i > 0 ? leftSum[i - 1] : 1;
            int right = i >= nums.length - 1 ? 1 : rightSum[i + 1];
            // System.out.println(left + " " + right + " " + i);
            res[i] = left * right;
        }
        return res;

    }
}  
