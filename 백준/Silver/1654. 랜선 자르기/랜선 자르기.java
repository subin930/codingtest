import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int K; //이미 가지고 있는 랜선의 개수
    public static int N; //목표 랜선의 개수
    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer str = new StringTokenizer(br.readLine());
        K = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        arr = new long[K];

        for(int i = 0; i < K; ++i) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long l = 1;
        long r = Arrays.stream(arr).max().getAsLong();

        long result = 0;

        while(l <= r) {
            long mid = l + (r - l) / 2;
            long cnt = count(mid);

            if(cnt < N) {
                //더 작게 잘라야 함
                r = mid - 1;
            } else {
                result = mid;
                l = mid + 1;
            }
        }

        bw.write(result + "");
        bw.flush(); br.close(); bw.close();
    }

    static long count(long target) {
        long cnt = 0;

        for(int i = 0; i < arr.length; ++i) {
            cnt += (arr[i] / target);
        }

        return cnt;
    }
}
