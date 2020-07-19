import java.util.*;

public class LC210 {    static int WHITE = 0;
    static int GRAY = 1;
    static int BLACK = 2;

    Map<Integer, Integer> colors = new HashMap<>();
    boolean cyclic = false;
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    List<Integer> topologicalOrder = new LinkedList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // first set all color to white.
        for(int i = 0; i < numCourses; i ++){
            colors.put(i, WHITE);
        }

        // create adjacency list
        for (int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int destination = prerequisite[0];
            List<Integer> curList = adjList.get(source);
            if (curList == null) {
                curList = new ArrayList<>();
            }
            curList.add(destination);
            adjList.put(source, curList);
        }

        // perform dfs on each node
        for(int i  = 0; i < numCourses; i ++){
            if(colors.get(i) == WHITE){
                DFS(i);
            }
        }


        int [] result;
        if(cyclic){
            result = new int[0];
        }
        else{
            result = new int[numCourses];
            for(int i = 0 ; i < numCourses; i ++){
                result[i] = topologicalOrder.get(numCourses - i - 1);
            }
        }

        return result;
    }

    public void DFS(int node){
        if(cyclic){
            return;
        }

        colors.put(node, GRAY);

        List<Integer> neighbours = adjList.get(node);
        if(neighbours != null){
            for (int neighbour: neighbours){
                if(colors.get(neighbour) == GRAY){
                    cyclic = true;
                }
                else if(colors.get(neighbour) == WHITE){
                    DFS(neighbour);
                }
            }
        }

        colors.put(node, BLACK);
        this.topologicalOrder.add(node);

    }
}