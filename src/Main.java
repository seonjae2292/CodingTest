import problem.Baek24480;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Baek24480 baek24480 = new Baek24480();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // initialize
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // create relation data
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        int[] visited = new int[N + 1];

        baek24480.solution(graph, R, visited);

        for (int i = 1; i < visited.length; i++) {
            System.out.print(visited[i] + " ");
        }
    }
}
