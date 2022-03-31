class Solution {
    public int majorityElement(int[] arr) {
        int n=arr.length;
        int max = 0;
        int index = -1; 
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j])
                    c++;
            }
            if (c > max) {
                max = c;
                index = i;
            }
        }
            return (arr[index]);
 
        
        
    }
}
