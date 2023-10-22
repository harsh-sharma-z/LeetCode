class Solution {
    public int maximumScore(int[] heights, int k) {
        Stack<Integer> uwu=new Stack<>();
        int maxarea=0;
        for(int i=0;i<heights.length;i++)
        {
            while(!uwu.isEmpty() && heights[i]<heights[uwu.peek()])
            {
                int h=heights[uwu.pop()];
                int r=i;
                if(r-1>=k){
                if(uwu.isEmpty())
                {
                    maxarea=Math.max(maxarea,h*r);
                }
                else
                {
                    int l=uwu.peek();
                    if(l+1<=k)
                    maxarea=Math.max(maxarea,h*(r-l-1));
                }
                }
            }
            uwu.push(i);
        }
        int r=heights.length;
         while(!uwu.isEmpty())
            {
                int h=heights[uwu.pop()];
             if(r-1>=k)
             {
                if(uwu.isEmpty())
                {
                    maxarea=Math.max(maxarea,h*r);
                }
                else
                {
                    int l=uwu.peek();
                    if(l+1<=k)
                    maxarea=Math.max(maxarea,h*(r-l-1));
                }
            }
         }
        return maxarea;
    }
}