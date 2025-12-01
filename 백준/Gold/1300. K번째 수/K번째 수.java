import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N =  Integer.parseInt(br.readLine());
        long k =  Integer.parseInt(br.readLine());

        long left = 1L;
        long right = N * N;
        long answer = 0;

        while(left <= right) {
            long mid = left + (right - left)/2;

            long size = findSize(mid);

            if(size >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static long findSize(long n) {
        long sum = 0;
        for(int i = 1; i <= N; ++i) {
            sum += Math.min(N, n / i);
        }

        return sum;
    }
}
