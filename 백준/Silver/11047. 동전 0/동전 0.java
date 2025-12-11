import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N; //N개의 동전
    public static int K; //목표 가치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int b = Arrays.binarySearch(arr, K);
        if(b < 0) b = -(b + 1) - 1;

        int cnt = 0;
        for(int i = b; i >= 0; --i) {
            int num = arr[i];

            while(K - num >= 0) {
                ++cnt;
                K -= num;
            }

            if(K == 0) break;
        }

        bw.write(cnt + "");
        bw.flush(); bw.close(); br.close();
    }
}
