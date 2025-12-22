import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        
        while(left <= right) {
            long mid = left + (right - left) / 2;
            long result = find(mid, times);
            
            if(result < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static long find(long time, int[] times) {
        //시간(분)이 주어졌을 때 수용 가능한 최대 명수 출력
        long result = 0;
        
        for(int i = 0; i < times.length; ++i) {
            result += (time / times[i]);
        }
        
        return result;
    }
}