class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
		int h = arr.length - 1;
		while (h - l >= k) {
			if (Math.abs(arr[l] - x) > Math.abs(arr[h] - x)) {
				l++;
			} else {
				h--;
			}
		}
		List<Integer> uwu = new ArrayList<>(k);
		for (int i = l; i <= h; i++) {
			uwu.add(arr[i]);
		}
		return uwu;
    }
}