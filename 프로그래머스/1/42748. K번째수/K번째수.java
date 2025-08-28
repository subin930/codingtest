import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>(commands.length * 2);
        
        for(int[] com : commands) {
            int[] arr = new int[com[1] - com[0] + 1];
            IntStream.rangeClosed(com[0], com[1]).forEach(i -> {arr[i - com[0]] = array[i - 1];});
            
            Arrays.sort(arr);
            
            answer.add(arr[com[2] - 1]);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}