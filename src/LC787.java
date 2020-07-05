import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // build an adjacency matrix
        int[][] adjMatrix = new int[n][n];
        for(int[] flight : flights){
            adjMatrix[flight[0]][flight[1]] = flight[2];
        }

        // the shortest distance from src to all points except itself is INF
        int [] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        // the stop from src to all points are 0, this will be bounded by K
        int [] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;

        // int[] in Priority used to store [point, distance, stop]
        PriorityQueue<int []> Q = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        Q.offer(new int[] {src, 0, -1});
        while(!Q.isEmpty()){
            int[] currentPoint = Q.poll();
            int U = currentPoint[0], dU = currentPoint[1], stopU = currentPoint[2];
            if(U == dst){
                return dU;
            }

            if(stopU > K)
                continue;


            // For neighbour V of currentPoint, update new distance
            for(int V = 0; V < n ;V ++){
                // if there exist a route from current point to V
                if(adjMatrix[U][V] != 0){
                    int distUV = adjMatrix[U][V];

                    if(dU + distUV < distance[V]){
                        Q.offer(new int[] {V, dU + distUV, stopU + 1});
                        distance[V] = distUV;
                    }
                    else if(stop[V] > stop[currentPoint[0]]){
                        Q.offer(new int[] {V, distUV, stopU + 1});
                        stop[V] = stop[currentPoint[0]];
                    }

                }

            }

        }

        // If there is no such route, output -1
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];

    }
}

