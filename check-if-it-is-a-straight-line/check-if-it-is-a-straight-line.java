class Solution {
    public boolean checkStraightLine(int[][] c) {
        int dy=c[1][1]-c[0][1];
        int dx=c[1][0]-c[0][0];
        int x=c[1][0];
        int y=c[1][1];
        for(int i[]:c)
        {
            if(dy*(i[0]-x)!=dx*(i[1]-y))
            return false;
        }
        return true;
    }
}