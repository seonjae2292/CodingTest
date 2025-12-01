import problem.Baek24444_R;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] visited;

    public static void main(String[] args) throws IOException {
        Baek24444_R baek24444_R = new Baek24444_R();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        // N 정점 개수, M 간선 개수, R 시작 정점, 오름차순, 무방향
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

        baek24444_R.bfs(graph, visited, R);

        for (int next : visited) {
            System.out.println(next);
        }
    }
}
