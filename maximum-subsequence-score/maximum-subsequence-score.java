class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][] arr=new int[n][2];
        PriorityQueue<Integer> uwu=new PriorityQueue<>(k,(a,b)->a-b);
        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums1[i];
            arr[i][1]=nums2[i];
        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        long res=0;
        long sum=0;
        for(int[] a:arr)
        {
            uwu.add(a[0]);
            sum+=a[0];
            if(uwu.size()>k)
            sum-=uwu.poll();
            if(uwu.size()==k)
            res=Math.max(res,(sum*a[1]));
        }
        return res;
    }
}