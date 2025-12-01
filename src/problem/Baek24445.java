package problem;

import java.util.*;

public class Baek24445 {
    public void bfs(ArrayList<ArrayList<Integer>> graph, int order, int[] visited, int startR) {
        // 1. 시작 정점 방문 순서 저장
        visited[startR] = order;

        // 2. queue에 시작 정점 저장
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startR);

        while (!(queue.isEmpty())) {
            // 3. 저장한 정점 추출
            int u = queue.poll();

            // 4. 추출한 정점에 인접하는 정점 순회하며 방문횟수 기록
            for (int next : graph.get(u)) {
                if (visited[next] == 0) {
                    visited[next] = ++order;
                    queue.add(next);
                }
            }
        }
    }
}
