import java.util.*;
public class DetectCycleInDirectedGraph {
    HashMap<Integer, Boolean> visited = new HashMap<>();
    HashMap<Integer, List<Integer>> graph;
    private boolean isCyclePresent(HashMap<Integer, List<Integer>> graph)
    {
        this.graph = graph; 
        for(int node : graph.keySet())
        {
            if(dfs(node, graph.get(node)))
                return true;
        }
        return false; 
    }

    private boolean dfs(int node, List<Integer> neighbhors)
    {
        if(visited.containsKey(node)) //node is either gray, black 
        {
            return visited.get(node) ? false : true;
        }

        //at this point, its a white node. Convert it to gray
        visited.put(node, false);

        for(int neighbhor : neighbhors)
        {
            if(dfs(neighbhor, graph.get(neighbhor)))
                return true;
        }

        //have traversed all the neighbhors, mark it as black 
        visited.put(node, true);
        return false; 
    } 

    public static void main(String args[])
    {
        DetectCycleInDirectedGraph detectCycleInDirectedGraph = new DetectCycleInDirectedGraph();
        HashMap<Integer, List<Integer>> graph1 = new HashMap<>();
        graph1.put(1, Arrays.asList(2,3));
        graph1.put(2, Arrays.asList(3,4,5));
        graph1.put(3, Arrays.asList(4));
        graph1.put(4, Arrays.asList(5));
        graph1.put(5, new ArrayList<>());
        System.out.println("\nIs cycle present in first graph? : "+ detectCycleInDirectedGraph.isCyclePresent(graph1));
        detectCycleInDirectedGraph.visited = new HashMap<>();
        HashMap<Integer, List<Integer>> graph2 = new HashMap<>();
        graph2.put(1, Arrays.asList(2,3));
        graph2.put(2, Arrays.asList(3,4));
        graph2.put(3, Arrays.asList(4));
        graph2.put(4, Arrays.asList(5));
        graph2.put(5, Arrays.asList(2));
        System.out.println("\nIs cycle present in second graph? : "+ detectCycleInDirectedGraph.isCyclePresent(graph2)+"\n");
    }
}
