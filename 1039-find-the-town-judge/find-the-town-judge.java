class Solution {
    public int findJudge(int n, int[][] trust) {
        int arr[]=new int[n+1];
        for(int a[]:trust)
        {
            arr[a[0]]=-1;
            if(arr[a[1]]!=-1)
                arr[a[1]]++;
        }
        for(int i=1;i<n+1;i++)
            if(arr[i]==n-1)
                return i;
        return -1;
    }
}