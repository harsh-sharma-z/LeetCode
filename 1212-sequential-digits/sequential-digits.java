class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String c = "123456789";
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < c.length(); i++) {
            for (int j = i + 1; j <= c.length(); j++) {
                int curr = Integer.parseInt(c.substring(i, j));
                if (curr <= high && curr >= low) {
                    a.add(curr);
                }
            }
        }

        a.sort(null);
        return a;
    }
}