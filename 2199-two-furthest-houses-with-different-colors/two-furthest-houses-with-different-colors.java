class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int left = 0 , right = 0;

        for(int i = 0 ; i < n ; i++) {
            if(colors[i] != colors[n - 1]) {
                left = i;
                break;
            }
        }

        for(int i = n -  1 ; i >= 0 ; i--) {
            if(colors[i] != colors[0]) {
                right = i;
                break;
            }
        }

        return Math.max(n - 1 - left , right);
    }
}