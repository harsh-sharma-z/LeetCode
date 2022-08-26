class Solution {
    int[] count (int n)
    {
        int arr[]=new int[10];
        while(n>0)
        {
            arr[n%10]++;
            n/=10;
        }
        return arr;
    }
    public boolean reorderedPowerOf2(int n) {
        int arr[]=count(n);
        int a=1;
        for(int i=0;i<31;i++)
        {
            if(Arrays.equals(arr,count(a)))
                return true;
            a*=2;
        }
        return false;
        
    }
}