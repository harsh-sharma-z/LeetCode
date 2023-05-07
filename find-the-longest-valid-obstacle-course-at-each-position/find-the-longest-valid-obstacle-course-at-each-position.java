class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n=obstacles.length,len=0, ans[]=new int[n], uwu[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int l=0,r=len;
            while(l<r)
            {
                int m=l+(r-l)/2;
                if(uwu[m]<=obstacles[i])
                l=m+1;
                else
                r=m;
            }
            uwu[l]=obstacles[i];
            ans[i]=l+1;
            if(len==l)
            len++;
        }
        return ans;
    }
}