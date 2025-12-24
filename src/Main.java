import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] visited;
    static int[] move;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사다리의 수
        M = Integer.parseInt(st.nextToken()); // 뱀의 수

        visited = new int[101];
        move = new int[101];

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());

            move[x] = Integer.parseInt(st.nextToken());
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int target = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = target + i;

                // next가 100이 되면 count를 반환해야한다.

                if(next > 100) continue;

                // 이미 방문 했는지 체크하기
                if (visited[next] == 0) {
                    if (move[next] != 0) {
                        visited[next] = 1; // 방문 체크
                        queue.add(move[next]);
                    }
                }
            }
        }
    }
}

// 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값? -> bfs
// 게임의 크기 10 * 10 -> 1 ~ 100 까지 순서대로 적혀있음
// 모든 칸은 최대 하나 사다리 또는 뱀 있음
// 동시에 두 가지를 모두 가지고 있는 경우는 없다 -> 방문 했던 곳은 또 다시 방문하지 않는다.

// 방문 체크
// map

// 주사위 돌린 횟수를 어떻게 카운트 하면될까?

// --------
// visited -> 방문했다만 저장하는 대신 여기까지 오는데 걸린 횟수 저장