class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length , p = n / 4;

        for(int i = 0 ; i < n - p ; i++)
            if(arr[i] == arr[i + p])
                return arr[i];

        return -1;
    }
}