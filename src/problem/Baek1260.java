package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek1260 {
    public void bfs(ArrayList<ArrayList<Integer>> graph, List<Integer> resultBFS, int[] visited, int V, int order) {
        visited[V] = order;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!(queue.isEmpty())) {
            int u = queue.poll();
            resultBFS.add(u);
            for (int next : graph.get(u)) {
                if (visited[next] == 0) {
                    visited[next] = ++order;
                    queue.add(next);
                }
            }
        }
    }

    public void dfs(ArrayList<ArrayList<Integer>> graph, List<Integer> resultDFS, int[] visited, int V, int order) {
        visited[V] = order;
        resultDFS.add(V);
        order++;

        for (int next : graph.get(V)) {
            if (visited[next] == 0) {
                dfs(graph, resultDFS, visited, next, order);
            }
        }
    }
}
