class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length;
        int n = people.length;

        int[] res = new int[n];

        int[] start = new int[m];
        int[] end = new int[m];

        for(int i = 0 ; i < m ; i ++){
            start[i] = flowers[i][0];;
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0 ; i < n ; i++){
            int bloomed = upperBound(start , people[i]);
            int died = lowerBound(end , people[i]);
            res[i] = bloomed - died;
        }

        return res;
    }

    private int upperBound(int[] arr , int target){
        int left = 0 ; 
        int right = arr.length - 1;

        int res = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] > target){
                res = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return res == -1 ? arr.length : res;
    }

    private int lowerBound(int[] arr , int target){
        int left = 0 ; 
        int right = arr.length - 1;

        int res = -1;

        while(left <= right){
            int mid = left + (right - left)  /2;

            if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                res = mid;
                right = mid - 1;
            }
        }

        return res == -1 ? arr.length : res;
    }
}