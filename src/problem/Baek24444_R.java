package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek24444_R {
    int order = 1;

    public void bfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int startR) {
        visited[startR] = order;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startR);

        while (!(queue.isEmpty())) {
            int u = queue.poll();

            for (int next : graph.get(u)) {
                if (visited[next] == 0) {
                    visited[next] = ++order;
                    queue.add(next);
                }
            }
        }
    }
}
