class Solution {
    static class Pair{
        int xi;
        int mi;
        int qi;

        public Pair(int a, int b, int c){
            this.xi=a;
            this.mi=b;
            this.qi=c;
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Pair[] query = new Pair[queries.length];

        Arrays.sort(nums);

        for(int i = 0 ; i < queries.length ; i ++){
            query[i]=new Pair(queries[i][0] , queries[i][1] , i);
        }

        Arrays.sort(query , new Comparator<Pair>(){
            public int compare ( Pair o1 , Pair o2 ){
                return o1.mi - o2.mi ;
            }
        });

        int ans[] =  new int[query.length];
        Node root = new Node();
        int j = 0;
        for(int i = 0 ; i < ans.length ; i++){
            while (j < nums.length && nums[j] <= query[i].mi){
                insert(root , nums[j]);
                j++;
            }
            if (j == 0){
                ans[query[i].qi] = -1;
            }
            else{
                ans[query[i].qi] = getMaxXor(root , query[i].xi);
            }
        }


        return ans;
    }







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
}