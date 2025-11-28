package problem;

import java.util.ArrayList;

public class Baek24479 {
    int cnt = 1; // 방문 순서

    public void solution(
            ArrayList<ArrayList<Integer>> graph, int[] visited, int R) {
        // 현재 방문한 정점에 순서 기록
        visited[R] = cnt;

        // 다음 순서를 위해 cnt + 1
        cnt++;

        // 현재 정점(R)과 연결된 정점을 확인
        for(int next : graph.get(R)) {
            if (visited[next] == 0) {
                solution(graph, visited, next);
            }
        }
    }
}

// visited의 index는 정점번호 의미
// cnt는 index에 해당 하는 값 즉, 몇번째로 방문했는지 기록