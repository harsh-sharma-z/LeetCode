import java.util.Arrays;

class Solution {
    public int minimumSum(int num) {
        
        String temp = Integer.toString(num);
    int[] newnum = new int[4];
    for (int i = 0; i < 4; i++)
    {
        newnum[i] = temp.charAt(i) - '0';
    }
        
        Arrays.sort(newnum);
        
        int a=(newnum[0]*10+newnum[2])+(newnum[1]*10+newnum[3]);
        
        int b=(newnum[0]*10+newnum[3])+(newnum[1]*10+newnum[2]);
        
        if(a>b)
            return b;
        return a;
        
    }
}