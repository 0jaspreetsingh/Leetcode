package Graph;

/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/solution/
 * todo
 */
public class ShortestPathVisitingAllNodes {


    public int shortestPathLength(int[][] graph) {
        int nodes = graph.length;
        return 0;
    }


    public static void main(String[] args) {
        ShortestPathVisitingAllNodes s = new ShortestPathVisitingAllNodes();
        int graph[][] = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(s.shortestPathLength(graph));
    }
}
