package problem;

import java.util.ArrayList;

public class Baek24480 {
    int cnt = 1;
    public void solution(ArrayList<ArrayList<Integer>> graph, int startR, int[] visited) {
        visited[startR] = cnt;
        cnt++;

        for (int num : graph.get(startR)) {
            if (visited[num] == 0) {
                solution(graph, num, visited);
            }
        }
    }
}
