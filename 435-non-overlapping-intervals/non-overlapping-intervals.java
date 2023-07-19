class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr , (int[] o1 , int[] o2) -> o1[0] - o2[0]);
        int c = 0;
        int i = 0 , j = 1;
        while(j < arr.length){
            int[] curr = arr[i];
            int[] next = arr[j];

            int cs = curr[0] , ce = curr[1];
            int ns = next[0] , ne = next[1];

            if(ce <= ns){//no overlapping
                i = j;
            }
            else if(ce <= ne){ // overlapping, but next vala bada interval hai
                c++;
            }
            else if(ce > ne){ // overlapping, but curr vala bada interval hai
                i = j;
                c++;
            }
            j++;
        }
        return c;
    }
}