import java.util.*;
class Solution {
    HashSet<Node> visited;
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) //mistake: you missed this part
            return null;
        visited = new HashSet<>();
        map = new HashMap<>();
        dfs(node, node.neighbors);
        return map.get(node);
    }
    
    private void dfs(Node node, List<Node> neighbors)
    {
        
        Node newNode = map.computeIfAbsent(node, o1 -> new Node(node.val, new ArrayList<>()));
        visited.add(node);
        for(Node neighbor : neighbors)
        {
            Node newNeighbor = map.computeIfAbsent(neighbor, o1 -> new Node(neighbor.val, new ArrayList<>()));       
            newNode.neighbors.add(newNeighbor);
            if(!visited.contains(neighbor))
                dfs(neighbor, neighbor.neighbors);   
        }
    }
}