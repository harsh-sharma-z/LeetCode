class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            List<Integer> temp; 
            if(map.containsKey(arr[i]))
                temp = new ArrayList<>(map.get(arr[i]));
            else
                temp = new ArrayList<>();
            temp.add(i);
            map.put(arr[i] , temp);
            if(map.get(arr[i]).size() == arr[i]){
                ans.add(map.get(arr[i]));
                map.put(arr[i] , new ArrayList<>());
            }
        }
        return ans;
    }
}