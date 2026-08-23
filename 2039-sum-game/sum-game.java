class Solution {
    public boolean sumGame(String num) {
        int n = num.length() / 2;

        int left = 0;
        int right = 0;

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            int value;

            if (ch == '?') {
                value = 9;
            } else {
                value = 2 * (ch - '0');
            }

            if (i < n) {
                left += value;
            } else {
                right += value;
            }
        }

        return left != right;
    }
}