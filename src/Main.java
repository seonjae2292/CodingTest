import java.io.*;
import java.util.*;

// 방문 기록&몇초 를 한번에 계산할거임
public class Main {
    static int[] map = new int[100001]; // N,K의 최댓값 + 1
    static int N, K;

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
        map[N] = 1; // 첫 번째 방문 기록

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 이동할 수 있는 위치
            int[] next = {curr + 1, curr - 1, curr * 2};

            // 이동할 수 있는 위치 탐색
            for (int item : next) {
                // 범위를 넘으면 안된다.
                if(item < 0 || item > 100000) continue;

                // 목표 위치에 왔으면 출력
                if (item == K) {
                    System.out.println(map[curr]);
                    return;
                }

                // 방문한 적 없어야 한다.
                if (map[item] == 0) {
                    queue.add(item);
                    map[item] = map[curr] + 1;
                }
            }
        }
    }
}

// 방문 기록 및 시간 기록
// 제약조건 : 이동한 곳의 범위(0이상 100,000 이하)
