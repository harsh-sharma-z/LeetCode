class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int row = heights.length;
        if (row == 0)
            return result;
        int col = heights[0].length;
        boolean[][] pacific = new boolean [row][col];
        boolean[][] atlantic = new boolean [row][col];
        
       
        for (int i = 0; i < col; ++i) {
            dfs(heights, 0, i, heights[0][i], pacific);
            dfs(heights, row-1, i, heights[row-1][i], atlantic);
        }
        
        
        for (int i = 0; i < row; ++i) {
            dfs(heights, i, 0, heights[i][0], pacific);
            dfs(heights, i, col-1, heights[i][col-1], atlantic);
        }
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(i);
                    currentResult.add(j);
                    result.add(currentResult);
                }
            }
        }
        return result;
        
    }
    
    private void dfs(int[][] matrix, int i, int j, int prevHeight, boolean[][] ocean) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || prevHeight > matrix[i][j] || ocean[i][j])
            return;
        ocean[i][j] = true;
        dfs(matrix, i+1, j, matrix[i][j], ocean);
        dfs(matrix, i-1, j, matrix[i][j], ocean);
        dfs(matrix, i, j+1, matrix[i][j], ocean);
        dfs(matrix, i, j-1, matrix[i][j], ocean);
    }
}