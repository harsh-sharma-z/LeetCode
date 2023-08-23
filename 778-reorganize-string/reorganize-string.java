class Solution {
    public String reorganizeString(String s) {
        HashMap<Character , Integer> uwu = new HashMap<>();
        for(char c : s.toCharArray()){
            uwu.put(c , uwu.getOrDefault(c , 0) + 1);
            if(uwu.get(c) > (s.length() + 1)/2)
                return "";
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue((a , b) -> uwu.get(b) - uwu.get(a));

        maxHeap.addAll(uwu.keySet());

        // if(uwu.get(maxHeap.peek()) > (s.length() + 1)/2)
        //     return "";

        char[] res = new char[s.length()];
        int i = 0;
        while(!maxHeap.isEmpty()){
            char c = maxHeap.poll();
            for(int j = 0 ; j < uwu.get(c) ; j++){
                if(i >= s.length())
                    i = 1;;
                res[i] = c;
                i += 2;
            }
        }
        return new String(res);
    }
}