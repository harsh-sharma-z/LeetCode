class Solution {
     public int[] numsSameConsecDiff(int n, int k) {
       
        int[] numbers = bfs(n,k);
        return numbers;
    }
    public int[] bfs(int n,int k){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=1;i<=9;i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int num = queue.poll();
            int numDigits = (int)Math.log10(num)+1;
            
            if(numDigits == n){
                result.add(num);
                continue;
            }
            int lastDigit = num%10;
            
            if(lastDigit+k<=9){
                queue.add(num*10+lastDigit+k);
            }
            
            if(lastDigit-k>=0 && k!=0){
                queue.add(num*10+lastDigit-k);
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}