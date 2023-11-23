class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;

        List<Boolean> res = new ArrayList<>();

        for(int i = 0 ; i < m ; i++){
            List<Integer> subArray = new ArrayList<>();
            for(int j = l[i] ; j <= r[i] ; j++){
                subArray.add(nums[j]);
            }
            res.add(check(subArray));
        }

        return res;
    }

    private boolean check(List<Integer> arr){
        int n = arr.size();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> uwu = new HashSet<>();

        for(int num : arr){
            min = Math.min(min , num);
            max = Math.max(max , num);
            uwu.add(num);
        }

        if((max - min) % (n - 1) != 0){
            return false;
        }

        int diff = (max - min) / (n - 1);
        int curr = min + diff;

        while(curr < max){
            if(!uwu.contains(curr)){
                return false;
            }
            curr += diff;
        }

        return true;
    }
}