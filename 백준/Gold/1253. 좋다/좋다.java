import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());

        arr = new int[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for(int i = 0; i < N; ++i) {
            if(find(i)) ++answer;
        }

        bw.write(answer + "");
        bw.flush();
        br.close(); bw.close();
    }

    static boolean find(int curIdx) {
        int target = arr[curIdx];

        int start = 0, end = arr.length - 1;

        while(start < end) {
            if(start == curIdx) {
                ++start;
                continue;
            } else if(end == curIdx) {
                --end;
                continue;
            }

            int sum = arr[start] + arr[end];

            if(sum == target) {
                return true;
            }
            else if(sum > target) end--;
            else start++;
        }

        return false;
    }
}
