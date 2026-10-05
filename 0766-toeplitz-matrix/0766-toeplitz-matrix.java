class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int row= 0; row< m-1;row++) {
            for (int col = 0; col < n-1; col++) {
               
                if(matrix[row][col]!= matrix[row+1][col +1]){
                    return false;
                }
            }
        }

        return true;
    }
}
