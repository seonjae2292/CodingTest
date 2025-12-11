import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, K;
    static int[] position = {1, -1, 2};
    static int time = 0;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        bfs();
    }

    // time
    // arrayList -> array
    // 범위 검사
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {

        }
    }
}