import java.util.*;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] row_min = new int[m];
        int[] col_max = new int[n];
        Arrays.fill(row_min, Integer.MAX_VALUE);
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                row_min[row] = Math.min(row_min[row], matrix[row][col]);
                col_max[col] = Math.max(col_max[col], matrix[row][col]);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == row_min[row] && matrix[row][col] == col_max[col]) {
                    ans.add(matrix[row][col]);
                }
            }
        }
        
        return ans;
    }
}