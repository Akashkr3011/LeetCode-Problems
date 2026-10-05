class Solution {
    public int numSpecial(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int []row_s=new int [m];
        int []col_s=new int[n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col]==1){
                    row_s[row]+=1;
                    col_s[col]+=1;
                }
            }
        }
        int count=0;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col]==1 && row_s[row]==1 && col_s[col]==1){
                    count++;
                }
            }
        }
        return count;
    }
}