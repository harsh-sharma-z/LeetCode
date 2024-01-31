class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n=t.length;
        Stack<Integer> uwu=new Stack<>();
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!uwu.isEmpty() && t[i]>=t[uwu.peek()]) // removing all the elements smaller than the current elememt from stack
                uwu.pop();
            if(!uwu.isEmpty())
                res[i]=uwu.peek()-i; // strong the number of days (difference of index)
            uwu.push(i); //to insert the current element in stack
        }
        return res;
    }
}