import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static int N;
    public static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]); //물건 개수
        C = Integer.parseInt(s[1]); //최대 허용 용량

        int[] stuff = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        comb(left, Arrays.copyOfRange(stuff, 0, N / 2), 0, 0);
        comb(right, Arrays.copyOfRange(stuff, N / 2, N), 0, 0);

//        System.out.println(left);
//        System.out.println(right);

        Collections.sort(right);

        int sum = 0;

        for(int i = 0; i < left.size(); ++i) {
            int idx = findIndex(right, C - left.get(i));

            sum += (idx + 1);
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }

    //배열에서 value 값 이하가 나오는 제일 마지막 위치!
    static int findIndex(ArrayList<Integer> arr, int val) {
        int left = 0;
        int right = arr.size();

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(arr.get(mid) > val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    static void comb(List<Integer> list, int[] arr, int cur, int sum) {
        if(sum > C) return;

        if(arr.length == cur) {
            //종료
            list.add(sum);
            return;
        }
        comb(list, arr, cur + 1, sum); //불포함
        comb(list, arr, cur + 1, sum + arr[cur]); //포함

    }

}
