/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<VerticalPair> q = new LinkedList<>();
        TreeMap<Integer , List<VerticalPair>> map = new TreeMap<>();
        q.add(new VerticalPair(0 , 0 , root));
        while(!q.isEmpty()) {
            VerticalPair rp = q.poll();
            if(!map.containsKey(rp.vl)){
                map.put(rp.vl , new ArrayList<>());
            }
            map.get(rp.vl).add(rp);
            if(rp.node.left != null){
                q.add(new VerticalPair (rp.hl+1 , rp.vl-1 , rp.node.left));
            }
            if(rp.node.right != null){
                q.add(new VerticalPair (rp.hl+1 , rp.vl+1 , rp.node.right));
            }
        }

        List<List<Integer>> ll = new ArrayList<>();

        for(int key : map.keySet()){
            List<VerticalPair> l = map.get(key);
            Collections.sort(l , new Comparator<VerticalPair>(){
                @Override
                public int compare(VerticalPair o1 , VerticalPair o2){
                    if(o1.hl == o2.hl){
                        return o1.node.val - o2.node.val;
                    }
                    return 0;
                }
            });
            List<Integer> l1 = new ArrayList<>();
            for(VerticalPair p : l){
                l1.add(p.node.val);
            }

            ll.add(new ArrayList<>(l1));

        }
        return ll;
    }

    class VerticalPair {
        int hl;
        int vl;
        TreeNode node;
        public VerticalPair (int hl , int vl , TreeNode node) {
            this.hl = hl;
            this.vl = vl;
            this.node = node;
        }
    }
}



















