import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N; //지방의 수
    public static int[] arr;
    public static int M; //총 예산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        예산 분배 -> 가능한 한 최대의 총 예산 배정
        1. 모든 요청 배정 가능 -> 요청 금액 그대로 배정
        2. 불가능 -> 특정한 정수 상한액을 계산 -> 그 이상인 예상 요청에는 모두 상한액을 배정
         */
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        int l = 1;
        int r = Arrays.stream(arr).max().getAsInt();
        int result = 0;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            long max = findSum(mid);
//            System.out.println(l + " " + r + " " + max);
            if(max <= M) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        bw.write(result + "");
        bw.flush(); br.close(); bw.close();
    }

    //예산 배분 총합 return
    static long findSum(int target) {
        long sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum += Math.min(target, arr[i]);
        }

        return sum;
    }
}
