import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n];
        int[][] check = new int[n + 1][n];

        for(int i = 0; i <= n; ++i) Arrays.fill(arr[i], -1);

        for(int i = 1; i <= n; ++i) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            for(int j = 0; j < i; ++j) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        check[1][0] = arr[1][0];
        for(int i = 2; i <= n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(j == 0) check[i][j] = check[i - 1][j] + arr[i][j];
                else if(j == i - 1) check[i][j] = check[i - 1][j - 1] + arr[i][j];
                else check[i][j] = Math.max(check[i-1][j - 1], check[i - 1][j]) + arr[i][j];
            }
        }

        bw.write(Arrays.stream(check[n]).max().getAsInt() + "");
        bw.flush();
        bw.close(); br.close();
    }
}
