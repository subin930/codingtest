import java.io.*;
import java.util.*;

public class Main{
    /*
    1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
     */
    public static int N; //집 개수
    public static int[][] arr; //가중치 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for(int i = 0; i < N; ++i) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(str.nextToken());
            arr[i][1] = Integer.parseInt(str.nextToken());
            arr[i][2] = Integer.parseInt(str.nextToken());
        }


        int[][] dp = new int[N + 1][3];

        for(int i = 1; i <= N; ++i) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i - 1][2];
        }

        bw.write(Arrays.stream(dp[N]).min().getAsInt() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
