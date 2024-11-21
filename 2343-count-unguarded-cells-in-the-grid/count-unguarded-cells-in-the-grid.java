class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        //Clean & empty matrix
        int[][] arr = new int[m][n];

        //Lets mark the gaurds and walls as 2
        for(int[] i : guards) {
            arr[i[0]][i[1]] = 2;
        }
        for(int[] i : walls) {
            arr[i[0]][i[1]] = 2;
        }

        int[][] dir = {{-1 , 0 , 1 , 0} , {0 , 1 , 0 , -1}};

        //Check mark every gaurd's LOS

        for(int[] i : guards) {
            for(int j = 0 ; j < 4 ; j++) {
                int  x = i[0] , y = i[1];
                int dx = dir[0][j] , dy = dir[1][j];

                while(x + dx >= 0 && x + dx < m && y + dy >= 0 && y + dy < n && arr[x + dx][y + dy] < 2) {
                    x += dx;
                    y += dy;
                    arr[x][y] = 1;
                }
            }
        }

        //Count ungaurded cells (with value = 0)
        int ungaurdedCells = 0;

        for(int i[] : arr) {
            for(int j : i) {
                if(j == 0) {
                    ungaurdedCells++;
                }
            }
        }

        return ungaurdedCells;
    }
}