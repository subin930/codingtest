import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);

        for(int i = 0; i < N; ++i) {
            int num = Integer.parseInt(str.nextToken());
            int bs = Arrays.binarySearch(arr, num);

            if(bs < 0) bs = -(bs + 1);
//            System.out.println(bs);

            if(arr[bs] > num) arr[bs] = num;
        }

        int answer = 0;
        for(int i = 0; i < N; ++i) {
            if(arr[i] < Integer.MAX_VALUE) answer = i + 1;
        }
        bw.write(answer + "");
        bw.flush();
        br.close(); bw.close();
    }
}
