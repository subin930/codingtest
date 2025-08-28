import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>(arr.length * 2);
        
        for(int i : arr) {
            if(q.isEmpty()) {
                q.add(i);
                continue;
            }
            
            if(i != q.peekLast()) {
                q.add(i);
            }
        }
        
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}