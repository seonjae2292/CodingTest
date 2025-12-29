import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] line = new int[101];
    static int[] map = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사다리의 수
        M = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            line[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.println(map[100] - 1);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 시작 지점
        map[1] = 1; // 시작 지점 방문 체크

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;

                if(next >= 101) continue;

                // 사다리나 뱀이 있으면 연결되어 있는 위치로 이동시켜야 한다.
                if (line[next] != 0) {
                    next = line[next];
                }

                if (map[next] == 0) {
                    queue.add(next);
                    map[next] = map[curr] + 1;
                }
            }
        }
    }
}

// 출력
// 주사위를 굴려야 하는 횟수의 최솟값

// 입력
// N : 사다리 개수
// M : 뱀의 개수

// 방문 체크 -> 0
// 뱀 또는 사다리가 있는지 체크 ->