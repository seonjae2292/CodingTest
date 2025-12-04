package problem;

import java.util.*;

public class Baek1260_R {
    public void DFS(ArrayList<ArrayList<Integer>> graph, int V, ArrayList<Integer> visitedDFS, int[] saveDFS) {
        saveDFS[V] = 1;
        visitedDFS.add(V);

        for (int next : graph.get(V)) {
            if (saveDFS[next] == 0) {
                DFS(graph, next, visitedDFS, saveDFS);
            }
        }
    }

    public void BFS(ArrayList<ArrayList<Integer>> graph, int V, ArrayList<Integer> visitedBFS, int[] saveBFS) {
        saveBFS[V] = 1;
        Queue<Integer> queue = new LinkedList<>();

        // 시작 정점
        queue.add(V);
        visitedBFS.add(V);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int next : graph.get(u)) {
                if (saveBFS[next] == 0) {
                    saveBFS[next] = 1;
                    // 다음 깊이 정점 방문을 위해 큐에 저장
                    queue.add(next);
                    visitedBFS.add(next);
                }
            }
        }
    }
}
