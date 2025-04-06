class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if(numRows == 0) {
            return ans;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);

        for(int i = 1 ; i < numRows ; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for(int j = 1 ; j < i ; j++) {
                int sum = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                temp.add(sum);
            }

            temp.add(1);

            ans.add(temp);
        }

        return ans;
    }
}