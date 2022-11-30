class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> uwu=new HashMap<>();
        for(int i:arr)
        {
                uwu.put(i,uwu.getOrDefault(i,0)+1);
        }
        int a[]=new int[1001];
         for (Map.Entry<Integer,Integer> mapElement : uwu.entrySet()) {
            int value = (mapElement.getValue() + 10);
             if(a[value]==1)
                 return false;
             a[value]=1;
        }
        return true;
        
    }
}