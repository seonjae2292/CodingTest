import problem.Baek24445;

import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static int order = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Baek24445 baek24445 = new Baek24445();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 정점 개수, 간선 개수, 시작 정점
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 2. 각 정점에 인접하는 정점 저장할 인접 리스트 생성 및 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 3. 문제에서 내림차순으로 방문한다 했으니 각 정점에 인접하는 정점을 내림차순으로 정렬
        // ex. 1 : [2, 4] -> [4, 2]
        for (int i = 0; i <= N; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        // 4. 정점의 방문 순서 저장할 배열 초기화
        visited = new int[N + 1];

        baek24445.bfs(graph, order, visited, R);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
}
