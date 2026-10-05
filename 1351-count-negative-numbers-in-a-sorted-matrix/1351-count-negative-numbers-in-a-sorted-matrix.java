class Solution {
    public int countNegatives(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int col=n-1;
        int row=0;
        while(col>=0 && row<m){
            if(grid[row][col]<0){
                col--;
                count+=m-row;
            }
            else{
                row++;
            }
        }
        return count;
    }
}