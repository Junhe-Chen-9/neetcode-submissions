class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i ++){
            // [-1, 0]
            int a = numbers[i]; // -1 
            int remains = target - a; // -1 - -1 = 0
            int idx = binarySearch(numbers,i + 1, numbers.length - 1,remains);
            if(idx != -1) return new int[]{i + 1,idx + 1};
        }
        return new int[]{};
    }
    private int binarySearch(int[] arr, int left, int right, int target){
        // base case
        if (left > right) return -1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(arr[pivot] == target) return pivot;
            if(arr[pivot] > target){
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }
        }
        return -1;
    }
}
