class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }
        for(int[] row : matrix){
            if(row == null || row.length == 0){
                return false;
            }
            int lastIndex = row.length - 1;
            if(target > row[lastIndex]){
                continue;
            } else {
                int l = 0;
                int r = row.length - 1;

                while(l < r){
                    int mid = l + (r - l) / 2;
                    if(target == row[mid]){
                        return true;
                    } else if (row[mid] < target){
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}
