import java.util.*;
import java.io.*;

/*
    N(보석 개수) K(가방 개수)
    M(무게) V(가격)
    ...
    C(가능한 최대 무게)
    1 가방 = 1 보석
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* inputs */
        StringTokenizer str1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str1.nextToken()); //보석 개수
        int K = Integer.parseInt(str1.nextToken()); //가방 개수

//        PriorityQueue<int[]> diamonds = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        ArrayList<int[]> arr = new ArrayList<>();
        int[] bags = new int[K]; //가방 정보 저장 (가능 무게)
        long answer = 0L;


        //보석 정보 저장
        for(int i = 0; i < N; ++i) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());
            arr.add(new int[] {Integer.parseInt(str2.nextToken()), Integer.parseInt(str2.nextToken())});
//            diamonds.offer(new int[] {Integer.parseInt(str2.nextToken()), Integer.parseInt(str2.nextToken())});
        }

        //가방 정보 저장
        for(int i = 0; i < K; ++i) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        //보석 정렬 (무게 오름차 순)
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //가방 정렬 (무게 오름차 순)
        Arrays.sort(bags);


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); //가치 순 (가치, 인덱스)
        int j = 0;

        //"가방" 기준으로 처리
        for(int i = 0; i < K; ++i) {
            int w = bags[i];

            //가방 무게보다 작은 보석들을 모두 큐에 넣음
            for(; j < arr.size(); ++j) {
                if(arr.get(j)[0] <= w) {
                    pq.offer(arr.get(j)[1]);
                } else {
                    break;
                }
            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }



        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
