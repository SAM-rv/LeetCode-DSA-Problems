class NumMatrix {
    int [][]matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;

        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j]=matrix[i][j]+matrix[i][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            sum= col1>0?sum+matrix[i][col2]-matrix[i][col1-1] : sum+matrix[i][col2];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */