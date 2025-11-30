import problem.Baek24444;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N 정점 개수, M 간선 개수, 무방향, 오름차순, R 시작 정점

        Baek24444 baek24444 = new Baek24444();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] visited = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
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

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        baek24444.bfs(graph, visited, R);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }
}
