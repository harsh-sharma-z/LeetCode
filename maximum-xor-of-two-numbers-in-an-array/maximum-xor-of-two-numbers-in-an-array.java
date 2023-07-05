class Solution {

    public static class Node{
        Node zero;
        Node one;
    }


    public void insert (Node root, int val) {
        Node curr = root;
        for(int i = 31 ; i >=0 ; i--){
            if((val & (1 << i)) == 0){
                if( curr.zero != null){
                    curr=curr.zero;
                }
                else{
                    Node nn = new Node();
                    curr.zero=nn;
                    curr = nn;
                }
            }
            else{
                if( curr.one != null){
                    curr = curr.one;
                }
                else{
                    Node nn = new Node();
                    curr.one = nn;
                    curr = nn;
                }
            }
        }
    }

    private static int getMaxXor ( Node root, int val ){
        int num = 0;
        Node curr = root;
        for( int i = 31 ; i >= 0 ; i--){
            int bit = val & (1 << i);

            if( bit == 0 ){
                if( curr.one != null ){
                    num += (1 << i);
                    curr = curr.one;
                }
                else{
                    curr = curr.zero;
                }
            }
            else{
                if( curr.zero != null){
                    num += (1 << i);
                    curr = curr.zero;
                }
                else{
                    curr = curr.one;
                }
            }
        }
        return num;
    }

    public int findMaximumXOR(int[] nums) {
        Node root=new Node();

        for(int i : nums)
            insert(root, i);

        int ans=Integer.MIN_VALUE;

        for(int i: nums){
            ans = Math.max( ans , getMaxXor(root, i) );
        }

        return ans;
    }
}