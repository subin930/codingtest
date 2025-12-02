import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static Deque<int[]> q = new ArrayDeque<>(); //큐(y, x, 부술 수 있는지, cnt)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken()); //행(세로)
        M = Integer.parseInt(str.nextToken()); //열(가로)

        int[][] arr = new int[N + 1][M + 1]; //0번째 행, 0번째 열은 버림

        for(int i = 1; i <= N; ++i) {
            String str2 = br.readLine();

            for(int j = 1; j <= M; ++j) {
                arr[i][j] = str2.charAt(j - 1) - '0';
            }
        }

        //로직
        boolean[][][] visited = new boolean[N + 1][M + 1][2]; //[][][0]: 벽을 부수고 도달한 상태, [][][1]: 벽을 부수지 않고 도달한 상태

        q.add(new int[] {1, 1, 1, 1});
        int answer = -1;

        while(!q.isEmpty()) {
            //우하단으로 가야함 (오른쪽 -> 아래 -> 위 -> 왼쪽)
            int[] tmp = q.pollFirst();
            int y = tmp[0], x = tmp[1], pos = tmp[2], cnt = tmp[3];
//            System.out.println("y: " + y + " x: " + x + " pos: " + pos + " cnt: " + cnt);
//            System.out.println();
//            printMap(arr, y, x);

            if(y == N && x == M) {
                answer = cnt;
                break;
            }

            check(arr, visited, y, x, pos, cnt);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check(int[][] arr, boolean[][][] visited, int y, int x, int pos, int cnt) {
        if(x < M) {
            //오른쪽
            if(arr[y][x + 1] == 0) {
                if(!visited[y][x + 1][pos]) {
                    visited[y][x + 1][pos] = true;
                    q.add(new int[] {y, x + 1, pos, cnt + 1});
                }
            } else {
                if(pos == 1) {
                    visited[y][x + 1][0] = true;
                    q.add(new int[] {y, x + 1, 0, cnt + 1});
                }
            }
        }
        if(y < N) {
            //아래
            if(arr[y + 1][x] == 0) {
                if(!visited[y + 1][x][pos]) {
                    visited[y + 1][x][pos] = true;
                    q.add(new int[] {y + 1, x, pos, cnt + 1});
                }
            } else {
                if(pos == 1) {
                    visited[y + 1][x][0] = true;
                    q.add(new int[] {y + 1, x, 0, cnt + 1});
                }
            }
        }
        if(y > 1) {
            //위
            if(arr[y - 1][x] == 0) {
                if(!visited[y - 1][x][pos]){
                    visited[y - 1][x][pos] = true;
                    q.add(new int[] {y - 1, x, pos, cnt + 1});
                }
            } else {
                if(pos == 1) {
                    visited[y - 1][x][0] = true;
                    q.add(new int[] {y - 1, x, 0, cnt + 1});
                }
            }
        }
        if(x > 1) {
            //왼쪽
            if(arr[y][x - 1] == 0) {
                if(!visited[y][x - 1][pos]) {
                    visited[y][x - 1][pos] = true;
                    q.add(new int[] {y, x - 1, pos, cnt + 1});
                }
            } else {
                if(pos == 1) {
                    visited[y][x - 1][0] = true;
                    q.add(new int[] {y, x - 1, 0, cnt + 1});
                }
            }
        }
    }

    public static void printMap(int[][] arr, int y, int x) {
        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= M; ++j) {
                if(i == y && j == x) System.out.print("! ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
