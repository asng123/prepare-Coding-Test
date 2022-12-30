import java.io.*;
import java.util.*;

// 참고
// https://youngest-programming.tistory.com/394

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = o1.split("[0-9]")[0].toLowerCase(); // head - number, tail 분리
            String head2 = o2.split("[0-9]")[0].toLowerCase(); // [0]은 잘린것 중에 첫번째 부분 즉 head
            if (head1.compareTo(head2) == 0) { // head 같은문자열인 경우
                String numTail1 = o1.substring(head1.length()); // number,tail 남김
                String numTail2 = o2.substring(head2.length());
                //Integer.parseInt("0023") = 23 출력된다. 앞에 0 잘림.
                return Integer.parseInt(calNumber(numTail1)) - Integer.parseInt(calNumber(numTail2));
            } else {
                //head가 같은 문자열 아니면 그냥 compareTo 하면된다.
                return head1.compareTo(head2);
            }
        });
        return files;
    }
    
    //number와 tail을 분리하는 함수
    private static String calNumber(String numTail2) { //최대 5자리인 number 계산
        StringBuilder sb2 = new StringBuilder();
        for (char c : numTail2.toCharArray()) {
            if (Character.isDigit(c) && sb2.length() <= 5) {
                sb2.append(c);
            } else {
                // 숫자 -> 문자 형태인 문자열이기 때문에 숫자가 아닐때 바로 return 하면된다.
                return sb2.toString();
            }
        }
        // tail이 없는 경우도 있어 for문이 끝나면 sb2.toString()을 return한다.
        return sb2.toString();
    }
}