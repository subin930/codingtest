import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //n: 전체 학생수, lost: 도난단한 학생들 번호 배열, reserve: 여벌 체육복 학생들 번호 배열 
        
        Set<Integer> lostS = new HashSet<>();
        Set<Integer> reserveS = new HashSet<>();
        
        Arrays.stream(lost).forEach(i -> lostS.add(i));
        Arrays.stream(reserve).forEach(i -> reserveS.add(i));
        
        //체육복 잃어버린 사람 처리
        for(int i : lost) {
            if(reserveS.contains(i)){
                lostS.remove(i);
                reserveS.remove(i);
            }
        }
        
        //빌려줄 수 있는 경우 처리
        for(int i : reserveS) {
            if(lostS.contains(i - 1)) {
                lostS.remove(i - 1);
            } else if(lostS.contains(i + 1)){ 
                lostS.remove(i + 1);
            }
        }
        
        return n - lostS.size();
    }
}