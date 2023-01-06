import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];     // numbers String 치환 배열
        for (int i=0; i<nums.length; i++)               // numbers를 순회하며
            nums[i] = numbers[i] + "";                  // String으로 변환

        Arrays.sort(nums, (o1, o2) -> {                 // arr정렬 방법(람다식)
            return (o2+o1).compareTo(o1+o2);            // ★610이 큰지 106이 큰지 비교함★
        });                                           
        
        StringBuilder ans = new StringBuilder();        // 정답 넣을 SB

        for (int i=0; i<numbers.length; i++)            // nums를 순회하면서
            ans.append(nums[i]);                        // ans에 넣어주기
        if(ans.toString().charAt(0) == '0')             // 첫글자가 0이라면
            return "0";                                 // return 0
        
        return ans.toString();                          // 그게아니라면 답 제출
    }
}