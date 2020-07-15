class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        if (rowLen == 0)
            return false;
        int colLen = matrix[0].length;

        for (int i = 0; i < rowLen && i >= 0; i++) {
            for (int j = 0; j < colLen && j >= 0; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    
                } else {

                }
            }
        }

        return false;
    }
}