import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);

        int M = Integer.parseInt(br.readLine());

        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < M; ++i) {
            if(binarySearch(a, target[i]) >= 0) bw.write("1\n");
            else bw.write("0\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
