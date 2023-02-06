class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        help(0,candidates.length,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
    
    private void help(int ind,int n,int k,int[] arr,List<Integer> uwu,List<List<Integer>> ans)
    {
        if(ind==n)
        {
            if(k==0)
            {
                ans.add(new ArrayList<>(uwu));

            }
            
                return ;
            
        }
        
        
        if(k>=arr[ind]){
            uwu.add(arr[ind]);
        help(ind,n,k-arr[ind],arr,uwu,ans);
        uwu.remove(uwu.size()-1);
        }
        help(ind+1,n,k,arr,uwu,ans);
    }
}