class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int left = 0, right = n - 1;
        int cnt = 0;
        while (left < n && directions.charAt(left) == 'L'){
            left++;
        }
        while (right >= 0 && directions.charAt(right) == 'R'){
            right--;
        }
        if (left > right){
            return 0;
        }
        for (int i = left; i <= right; i++){
            if (directions.charAt(i) != 'S'){
                cnt++;
            }
        }
        return cnt;
    }
}