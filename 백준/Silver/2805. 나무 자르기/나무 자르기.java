import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]); //나무의 수
        long M = Integer.parseInt(s1[1]); //나무의 길이

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt();
        int answer = left;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            boolean check = checkPossible(N, M, mid, arr);

            if(!check) {
                //수량 못 미침 -> 왼쪽으로
                right = mid - 1;
            } else {
                //수량 가능
                answer = mid;
                left = mid + 1;
            }
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }

    //target: 해당 높이에서 자르면
    static boolean checkPossible(int N, long M, int target, int[] arr) {
        long sum = 0;

        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] > target) sum += (arr[i] - target);
        }

        return M <= sum;
    }
}
