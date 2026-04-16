class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        // Map each value -> list of indices where it appears
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        
        // ----- Step 1: Build the index lists -----
        for (int i = 0; i < n; i++) {
            // getOrDefault: if the list doesn't exist, create a new empty ArrayList
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);                 // add the current index
            map.put(nums[i], list);      // put back (same list, but safe)
        }
        // Now map contains for every distinct value a sorted list of indices
        // (sorted because we iterate i from 0 to n-1)
        
        // ----- Step 2: Process each query -----
        for (int i = 0; i < queries.length; i++) {
            int queryIndex = queries[i];            // the index we are asking about
            int targetValue = nums[queryIndex];     // the value at that index
            List<Integer> indices = map.get(targetValue); // list of all indices with that value
            
            // If the value appears only once (the list size is 1) -> no other index -> -1
            if (indices.size() == 1) {
                res.add(-1);
                continue;   // move to the next query
            }
            
            // Find the position of queryIndex inside its own list using binary search
            int pos = binSearch(indices, queryIndex);
            int size = indices.size();
            
            // Get the immediate neighbours in the list (circular)
            // (pos-1 + size) % size handles wrap-around for the previous element
            int prevIndex = indices.get((pos - 1 + size) % size);
            int nextIndex = indices.get((pos + 1) % size);
            
            // Circular distance from queryIndex to prevIndex
            int distPrev = Math.min(Math.abs(queryIndex - prevIndex),
                                    n - Math.abs(queryIndex - prevIndex));
            // Circular distance from queryIndex to nextIndex
            int distNext = Math.min(Math.abs(queryIndex - nextIndex),
                                    n - Math.abs(queryIndex - nextIndex));
            
            // The answer is the smaller of the two distances
            res.add(Math.min(distPrev, distNext));
        }
        
        return res;
    }
    
    // ----- Standard binary search on a sorted list -----
    // Returns the index (position) where 'target' is found, or -1 if not present
    private int binSearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = list.get(mid);
            if (midVal == target) {
                return mid;          // found exact position
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;   // should never happen for valid queries, but kept for safety
    }
}