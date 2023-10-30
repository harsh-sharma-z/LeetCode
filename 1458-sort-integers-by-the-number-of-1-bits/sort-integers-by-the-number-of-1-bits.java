class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] brr = new Integer[n];
        for(int i = 0 ; i <  n ; i++)
            brr[i] = arr[i];
        
        Arrays.sort(brr , (a , b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if(countA == countB)
                return a.compareTo(b);
            
            return Integer.compare(countA , countB);
        });

        for(int i = 0 ; i < n ; i++)
            arr[i] = brr[i];
        
        return arr;
    }
}