class Solution {
    public int search(int[] nums, int target) {
        int rotation_point = binarySearchRotationPoint(nums);
        if(target >= nums[0] && target <= nums[rotation_point]){
            return binarySearch(nums,0,rotation_point,target);
        }else{
            return binarySearch(nums,rotation_point + 1, nums.length - 1,target);
        }
    }
    private int binarySearchRotationPoint(int[] nums){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(pivot < nums.length - 1 && nums[pivot] > nums[pivot + 1]){
                return pivot;
            }
            if(pivot > 0 && nums[pivot - 1] > nums[pivot]) return pivot - 1;
            if (nums[pivot] > nums[right]) {
                left = pivot + 1;  // Min element is to the right
            } else {
                right = pivot - 1; // Min element is to the left
            }

        }
        return 0;
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] > target){
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }
        }
        return -1;
    }
}
