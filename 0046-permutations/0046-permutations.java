class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> uwu=new ArrayList<>();
        // List<Integer> ds=new ArrayList<>();
       // boolean freq[]=new boolean[nums.length];
        help(0,nums,uwu);
        return uwu;
    }
//     private void help(List<Integer> ds,List<List<Integer>> uwu,int[] nums,boolean[] freq)
//     {
    //approach wiht extra space
//         if(ds.size()==nums.length){
//             uwu.add(new ArrayList<>(ds));
//             return ;
//         }
//         for(int i=0;i<nums.length;i++)
//         {
            
//             if(!freq[i])
//             {
//                 ds.add(nums[i]);
//                 freq[i]=true;
//                 help(ds,uwu,nums,freq);
//                 ds.remove(ds.size()-1);
//                 freq[i]=false;
//             }
//         }
//     }
    
    private void help(int ind,int[]nums,List<List<Integer>> uwu)
    {
        //without extra space
        if(ind==nums.length)
        {
            List<Integer> ds=new ArrayList<>();
            for(int j=0;j<nums.length;j++)
                ds.add(nums[j]);
            uwu.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=ind;i<nums.length;i++)
        {
            swap(i,ind,nums);
            help(ind+1,nums,uwu);
            swap(i,ind,nums);
        }
    }
    
    private void swap(int a,int b,int[] nums)
    {
        int temp=nums[b];
        nums[b]=nums[a];
        nums[a]=temp;
    }
}