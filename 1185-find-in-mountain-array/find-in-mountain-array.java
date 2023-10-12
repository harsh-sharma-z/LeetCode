/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    HashMap<Integer,Integer> mountCache =  new HashMap<>();
    MountainArray mountainArr;
    
    int getMountVal(int index)
    {
        if(mountCache.containsKey(index))
            return mountCache.get(index);
        mountCache.put(index,mountainArr.get(index));
             return mountCache.get(index);
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        this.mountainArr=mountainArr;
        int peak=findPeak(1, mountainArr.length()-1);
        int res=searchAsc(0,peak,target);
        if(res!=-1)
            return res;
        res=searchDesc(peak,mountainArr.length()-1, target);
        return res;
    }
    int findPeak (int low, int high){
        int mid=(low+high)/2;
        if(getMountVal(mid)> getMountVal(mid-1) && getMountVal(mid)> getMountVal(mid+1))
            return mid;
        if(getMountVal(mid)> getMountVal(mid-1) && getMountVal(mid)< getMountVal(mid+1))
            return findPeak(mid+1, high);
        if(getMountVal(mid)< getMountVal(mid-1) && getMountVal(mid)> getMountVal(mid+1))
            return findPeak(low,mid-1);
        return -1;
    }
    int searchAsc(int low, int high, int target)
    {
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        
        if(getMountVal(mid)==target)
            return mid;
        if(getMountVal(mid)<target)
            return searchAsc(mid+1, high, target );
        if(getMountVal(mid)>target)
            return searchAsc(low,mid-1,target);
        return -1;
    }
    int searchDesc(int low, int high, int target)
    {
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        
        if(getMountVal(mid)==target)
            return mid;
        if(getMountVal(mid)>target)
            return searchDesc(mid+1, high, target );
        if(getMountVal(mid)<target)
            return searchDesc(low,mid-1,target);
        return -1;
    }
}