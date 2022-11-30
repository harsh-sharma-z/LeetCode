class Solution {
    public boolean containsDuplicate(int[] nums) {
         Set<Integer> uwu = new HashSet<>();
        for(int i: nums) 
            if(!uwu.add(i))
                return true;
        return false;
    }
}