import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

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

        dfs(R);

        for (int i=1; i<visited.length; i++) {
            System.out.print(visited[i] + " ");
        }
//        baek22479.solution(graph, visited, R);

//        int N = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                sb.append("*");
//            }
//        }
//        baek2447.solution(N, sb);

//        String line;
//        while ((line = br.readLine()) != null) { // EOF 처리
//            if (line.trim().isEmpty()) continue;
//
//            int N = Integer.parseInt(line.trim());
//            int strlen = (int) Math.pow(3, N);
//
//            // 1. StringBuilder로 기본 세팅 (모두 '-'로 채움)
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < strlen; i++) {
//                sb.append("-");
//            }
//        }
    }

    public static void dfs(int startR) {
        visited[startR] = cnt;
        cnt++;

        for (int num : graph.get(startR)) {
            if (visited[num] == 0) { // 방문한적 있는지 체크 필요
                dfs(num);
            }
        }
    }
}
