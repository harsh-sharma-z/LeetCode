/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node > uwu=new HashMap<>();
    public Node cloneGraph(Node node) {
        return help(node);
    }
    private Node help(Node node)
    {
        if(node == null)
            return null;
        if(uwu.containsKey(node.val))
            return uwu.get(node.val);
        Node clone=new Node(node.val);
        uwu.put(clone.val,clone);
        for(Node nbrs: node.neighbors)
        {
            clone.neighbors.add(help(nbrs));
        }
        return clone;
    }
}