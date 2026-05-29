/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        Map<Node, Node> oldToNewMap = new HashMap<>();
        Node newNode = new Node(node.val);
        oldToNewMap.put(node, newNode);

        Queue<Node> bfsQ = new ArrayDeque<>();
        bfsQ.offer(node);
        
        while(!bfsQ.isEmpty()){
            Node curr = bfsQ.poll();
            for(Node neigh: curr.neighbors){
                // Create and add new neigh to map only if not seen already
                if(!oldToNewMap.containsKey(neigh)){
                    Node newNeigh = new Node(neigh.val);
                    oldToNewMap.put(neigh, newNeigh);
                    bfsQ.offer(neigh);
                }
                oldToNewMap.get(curr).neighbors.add(oldToNewMap.get(neigh));
            }
        }

        return newNode;
    }
}