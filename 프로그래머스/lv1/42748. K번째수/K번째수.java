import java.util.*;

// ArrayList 정렬 방법
// list.sort(Comparator.naturalOrder());
class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();  // return할 답

        ArrayList<Integer> temp = new ArrayList<>();    // commands에 맞게 자른 배열
        for(int i=0;i<commands.length;i++){                     // commands 순회하면서            
            for(int j=commands[i][0]-1;j< commands[i][1];j++)  // 자른배열 만들기
                temp.add(array[j]);

            Collections.sort(temp);                 // 자른배열 정렬
            answer.add(temp.get(commands[i][2]-1)); // commands에 맞게 answer에 넣기
            temp.clear();                           // temp 재사용을 위해 clear()
        }
        
        return answer;
    }
}
