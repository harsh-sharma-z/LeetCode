class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> uwu = new Stack<>();
        for(int a : asteroids){
            while(!uwu.isEmpty() && a < 0 && uwu.peek() > 0){
                int sum = a + uwu.peek();
                if(sum < 0){
                    uwu.pop();
                }
                else if(sum > 0){
                    a = 0;
                }
                else{
                    uwu.pop();
                    a = 0;
                }
            }
            if(a != 0){
                uwu.push(a);
            }
        }
        
        int n = uwu.size() - 1;
        int[] ans = new int[n+1];
        while(!uwu.isEmpty())
            ans[n--] = uwu.pop();

        return ans;
    }
}