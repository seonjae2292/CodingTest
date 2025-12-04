import problem.Baek1260_R;

import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    // 방문한 곳
    static ArrayList<Integer> visitedDFS = new ArrayList<>();
    static ArrayList<Integer> visitedBFS = new ArrayList<>();

    // 방문 기록
    static int[] saveDFS;
    static int[] saveBFS;

    public static void main(String[] args) throws IOException {
        Baek1260_R baek1260_R = new Baek1260_R();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        saveDFS = new int[N + 1];
        saveBFS = new int[N + 1];

        // 입력
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 정렬 : 오름차순
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        baek1260_R.DFS(graph, V, visitedDFS, saveDFS);
        baek1260_R.BFS(graph, V, visitedBFS, saveBFS);
    }
}
