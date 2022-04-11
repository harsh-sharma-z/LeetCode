class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        
        
        int temp[][] = new int[row][col];
        
       
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                
             
                int indexIn1DArray = ((i * col) + j + k ) % (row * col);
               
                int tempRowIndex = indexIn1DArray / col; 
                int tempColIndex = indexIn1DArray % col; 
                temp[tempRowIndex][tempColIndex] = grid[i][j]; 
            }
        }
        
   
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < col; j++) {
                list.add(temp[i][j]);
            }
            result.add(list);
        }
        
        return result;
    }
}
