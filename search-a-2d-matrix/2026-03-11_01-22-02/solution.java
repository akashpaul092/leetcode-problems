class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int col = matrix[0].length - 1;
        int row = 0;
        while(top <= bottom){
            int mid = (top + bottom) >> 1;

            if(matrix[mid][0] <= target && target <= matrix[mid][col]){
                row = mid;
                break;
            }else if(matrix[mid][0] > target){
                bottom = mid - 1;
            }else{
                top = mid + 1;
            }
        }

        int left = 0;
        int right = col;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}