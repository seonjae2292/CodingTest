package problem;

import java.util.ArrayList;

public class Baek24480_R {
    int cnt = 1;

    public void solution(ArrayList<ArrayList<Integer>> graph, int startR, int[] visited) {
         visited[startR] = cnt;
         cnt++;

        for (int next : graph.get(startR)) {
            if (visited[next] == 0) {
                solution(graph, next, visited);
            }
        }
    }
}
