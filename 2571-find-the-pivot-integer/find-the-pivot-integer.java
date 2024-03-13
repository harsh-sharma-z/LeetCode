class Solution {
    public int pivotInteger(int n) {
        final int sum = (n * (n + 1)/ 2);
        final int pivot = (int) Math.sqrt(sum);
        return pivot * pivot == sum ? pivot : -1;
    }
}