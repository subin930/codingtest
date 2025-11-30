import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); //강의 개수
        int M = Integer.parseInt(s[1]); //블루레이 개수
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //강의 배열

        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();

        bw.write(binarySearch(left, right, M, arr) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int left, int right, int M, int[] arr) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = checkPossible(M, mid, arr);

            if(cnt < 0) {
                //더 큰 블루레이 필요
                left = mid + 1;
            } else {
                right = mid - 1;
                q.offer(mid);
            }
        }

        return q.peek();
    }

    static int checkPossible(int M, int target, int[] arr) {
        int cnt = 1;
        int sum = 0;

        for(int i = 0; i < arr.length; ++i) {
            sum += arr[i];

            if(sum > target) {
                cnt++;
                sum = arr[i];
            }
        }

        return M - cnt;
    }
}
