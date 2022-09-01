/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
      if(n==1)
        return 1;
        int low=1,high=n;
        int mid;
       

        while(high-low>0)
        {
            mid=low+((high-low)>>2);
            if(isBadVersion(mid))
            high=mid;
            else
            low=mid+1;


        }
        return high;
    }
}