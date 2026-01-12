class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] ans=new int[matrix[0].length];
        int area=0;
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                    ans[j]++;
                else
                    ans[j]=0;
            }
            area = Math.max(area,help(ans));
        }
        
        
        return area;
    }
    
    public int help(int [] heights)
    {
        Stack<Integer> uwu=new Stack<>();
        int maxarea=0;
        for(int i=0;i<heights.length;i++)
        {
            while(!uwu.isEmpty() && heights[i]<heights[uwu.peek()])
            {
                int h=heights[uwu.pop()];
                int r=i;
                
                if(uwu.isEmpty())
                {
                    maxarea=Math.max(maxarea,h*r);
                }
                else
                {
                    int l=uwu.peek();
                    
                    maxarea=Math.max(maxarea,h*(r-l-1));
                }
                
            }
            uwu.push(i);
        }
        int r=heights.length;
         while(!uwu.isEmpty())
            {
                int h=heights[uwu.pop()];
             
                if(uwu.isEmpty())
                {
                    maxarea=Math.max(maxarea,h*r);
                }
                else
                {
                    int l=uwu.peek();
               
                    maxarea=Math.max(maxarea,h*(r-l-1));
                }
            }
         
        return maxarea;
    }
}