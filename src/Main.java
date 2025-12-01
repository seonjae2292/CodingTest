import problem.Baek1260;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Baek1260 baek1260 = new Baek1260();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int[] visitedDFS = new int[N + 1];
        int[] visitedBFS = new int[N + 1];

        List<Integer> resultDFS = new ArrayList<>();
        List<Integer> resultBFS = new ArrayList<>();

        int orderDFS = 1;
        int orderBFS = 1;

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

        baek1260.dfs(graph, resultDFS, visitedDFS, V, orderDFS);
        baek1260.bfs(graph, resultBFS, visitedBFS, V, orderBFS);

        for (int item : resultDFS) {
            System.out.print(item + " ");
        }
        System.out.println();
        for (int item : resultBFS) {
            System.out.print(item + " ");
        }
    }
}
// 방문된 점을 순서대로 출력