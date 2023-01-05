import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        // 답
        ArrayList<Integer> answer = new ArrayList<>();
        // 자른배열
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i< commands.length;i++){
            // 자른배열 만들기
            for(int j = commands[i][0]-1; j< commands[i][1];j++){
                temp.add(array[j]);
            }
            // 정렬
            // ** ArrayList 정렬 방법
            // temp.sort(Comparator.naturalOrder());
            Collections.sort(temp);
            //답안 넣기
            answer.add(temp.get(commands[i][2]-1));
            temp.clear();
        }
        
        return answer;
    }
}
