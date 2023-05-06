class Solution {
    public String predictPartyVictory(String senate) {
        int a = 0, b = 0;
        String res = "";
        char[] chars = senate.toCharArray();
        while (true) {
            boolean fa = false;
            boolean fb = false;
            for (int i = 0; i < senate.length(); i++) {
                if (chars[i] == 'D') {
                    if (b > 0) {
                        chars[i] = '-';
                        b--;
                    }
                    else {
                        a++;
                        fa = true;
                    }
                } else if (chars[i] == 'R') {
                    if (a > 0) {
                        a--;
                        chars[i] = '-';
                    }
                    else {
                        fb = true;
                        b++;
                    }
                }
            }
            if (fa && !fb) {
                res = "Dire";
                break;
            } else if (!fa && fb) {
                res = "Radiant";
                break;
            }
        }
        return res;
    }
}