package problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2606 {
    static int startR = 1; // 시작 정점
    static int order = 1; // 방문 기록용

    public int bfs(ArrayList<ArrayList<Integer>> graph, int[] visited) {
        int count = 0;
        visited[startR] = order;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startR);

        while (!(queue.isEmpty())) {
            int u = queue.poll();

            for (int next : graph.get(u)) {
                if (visited[next] == 0) {
                    visited[next] = order;
                    count++;
                    queue.add(next);
                }
            }
        }

        return count;
    }
}
