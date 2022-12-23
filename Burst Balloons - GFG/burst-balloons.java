//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static Integer[][]dp;
  public static int maxCoins(int N, int[] arr) {
    // code here
    dp=new Integer[N+3][N+3];
    int[]newArr=new int[N+2];
    newArr[0]=1;
    newArr[N+1]=1;
    for(int i=0;i<N;i++){
        newArr[i+1]=arr[i];
    }
    return dfs(0,N+1,newArr);
  }
  static int dfs(int l,int r,int[]arr){
      int ans=0;
      if(dp[l][r]!=null)return dp[l][r];
      for(int i=l+1;i<r;i++){
          int temp= arr[l]*arr[i]*arr[r] + dfs(i,r,arr) + dfs(l,i,arr);
          ans=Math.max(ans,temp);
      }
      return dp[l][r]=ans;
  }
}
     