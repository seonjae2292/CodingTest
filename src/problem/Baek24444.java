package problem;

import java.util.*;

public class Baek24444 {
    int cnt = 1;

    public void bfs(ArrayList<ArrayList<Integer>> graph, int[] visited, int startR) {
        visited[startR] = cnt;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startR);
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph.get(u)) {
                if (visited[v] == 0) {
                    visited[v] = ++cnt;
                    queue.add(v);
                }
            }
        }
    }
}
