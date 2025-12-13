import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1; // 시작점 방문 처리?

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                // 목표 지점에 도달했는지 확인
                if (next == K) {
                    System.out.println(visited[current]);
                    return;
                }

                // 유효성 검사 ( 범위를 벗어나지 않고 & 방문하지 않았던 곳만
                if (next >= 0 && next < 100001 && visited[next] == 0) {
                    visited[next] = visited[current] + 1; // 시간 1초 증가
                    queue.add(next);
                }
            }
        }
    }
}
// visitied : 내가 이곳을 방문했는지 체크, 시작점으로부터 여기까지 오는데 걸린 시간(거리)

