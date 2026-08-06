class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search first col to locate the row 
        int row = binarySearchRow(matrix, target);
        return binarySearch(matrix[row], target);
    }
    private boolean binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(arr[pivot] == target) return true;
            if(arr[pivot] > target){
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }
        }
        return false;
    }
    private int binarySearchRow(int[][] grid, int target){
        // base case 
        int left = 0;
        int right = grid.length - 1;
        while(left <= right){
            int pivot = left + (right - left) / 2;
            if(grid[pivot][0] > target){
                // we know it def not here 
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }
        }
        return right >= 0 ? right : 0;
    }
}
