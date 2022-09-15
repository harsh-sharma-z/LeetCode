class Solution {
    public int[] findOriginalArray(int[] changed) {
        if((changed.length)%2!=0) 
            return new int[0];
        int[] uwu=new int[100001];
        for(int i:changed) 
            uwu[i]++;
        
         if (uwu[0] > 0 && uwu[0] % 2 != 0)
             return new int[0];
        int ans[]=new int[changed.length/2];
        int j=0;
        for(int i=0;i<uwu.length;i++){
            while(uwu[i]>0 && ((i*2)<100001) && uwu[i*2]>0){
                uwu[i]--;
                uwu[i*2]--;
                ans[j++]=i;
            }
        }
        for(int i=0;i<uwu.length;i++) 
            if(uwu[i]!=0) 
                return new int[0];
        return ans;
    }
    
}