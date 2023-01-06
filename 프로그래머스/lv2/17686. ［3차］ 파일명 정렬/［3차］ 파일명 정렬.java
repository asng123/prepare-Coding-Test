import java.io.*;
import java.util.*;

// 참고
// https://youngest-programming.tistory.com/394

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {                        // files를 문제에서 주어진 조건에 맞춰 정렬한다
            String head1 = o1.split("[0-9]")[0].toLowerCase();  // split("[0-9]"):문자열을 숫자를 기준으로 split,
            String head2 = o2.split("[0-9]")[0].toLowerCase();  // return된 배열중 첫번째를 선택
            if (head1.compareTo(head2) == 0) {                  // head가 같은문자열인 경우, number 기준으로 정렬
                String numTail1 = o1.substring(head1.length()); // substring을 통해 head - number,tail 분리
                String numTail2 = o2.substring(head2.length());               
                return Integer.parseInt(calNumber(numTail1)) - Integer.parseInt(calNumber(numTail2)); // 앞에 0 잘림
            } else {
                return head1.compareTo(head2);                  // head가 다르다면 head기준 정렬
            }
        });
        
        return files;
    }

    private static String calNumber(String numTail) {           // number와 tail을 분리하는 함수
        StringBuilder num = new StringBuilder();                // number를 담을 SB               
        for (char c : numTail.toCharArray()) {                  // numTail을 char배열로 변환해 순회
            if (Character.isDigit(c) && num.length() <= 5)      // c가 숫자라면
                num.append(c);                                  // 넣기
            else                                                // c가 문자라면
                return num.toString();                          // num-tail 분리 끝
        }
        return num.toString();                                  // tail이 없는 경우 return해줄 곳
    }
}
