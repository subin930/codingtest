import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수

        for(int t = 0; t < T; ++t) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(str.nextToken());  //배추밭 가로 길이
            int N = Integer.parseInt(str.nextToken());  //배추밭 세로 길이
            int K = Integer.parseInt(str.nextToken());  //배추 개수

            int[][] arr = new int[N][M];

            for (int i = 0; i < K; ++i) {
                //X(가로) Y(세로)
                StringTokenizer str2 = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(str2.nextToken());
                int y = Integer.parseInt(str2.nextToken());

                arr[y][x] = 1;
            }

            //로직 시작
            int cnt = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (arr[i][j] == 1) {
                        search(arr, i, j, N, M);
                        ++cnt;
                    }
                }
            }

            bw.write(cnt + "");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /*
        주변 모두 0으로 바꾸는 함수
     */
    static void search(int[][] arr, int y, int x, int N, int M) {
        if(arr[y][x] == 0) return;

        arr[y][x] = 0;

        //상
        if(y > 0) search(arr, y - 1, x, N, M);

        //하
        if(y < N - 1) search(arr, y + 1, x, N, M);

        //좌
        if(x > 0) search(arr, y, x - 1, N, M);

        //우
        if(x < M - 1) search(arr, y, x + 1, N, M);
    }
}