class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index;
        int move = length - 1; //단방향 이동 시 
        
        for(int i = 0; i < length; ++i) {
            answer += getCnt(name.charAt(i));
            
            //연속 A 개수 체크 
            index = i + 1;
            while(index < length && name.charAt(index) == 'A') ++index;
            
            //JJJAAAANNNN과 같은 경우(연속된 A 배열의 앞부분이 더 짧은 경우) - J -> J -> J -> N -> N -> N -> N
            move = Math.min(move, i * 2 + length - index);
            
            //JJJJAAAANN과 같은 경우(연속된 A 배열의 앞부분이 더 긴 경우) - N -> N -> J -> J -> J -> J (뒤에부터 순회)
            move = Math.min(move, (length - index) * 2 + i);
            
        }
        
        return answer + move;
    }
    
    static int getCnt(char target) {
        return Math.min(target - 'A', 'Z' - target + 1);
    }
}