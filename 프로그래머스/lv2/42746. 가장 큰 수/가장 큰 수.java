import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // numbers String 치환 배열
        String[] nums = new String[numbers.length];
        // nums에 자리수 String으로 변경후 대입
        for (int i=0; i<nums.length; i++) 
            nums[i] = numbers[i] + "";
        // arr정렬방법(람다식)
        Arrays.sort(nums, (o1, o2) -> {
            return (o2+o1).compareTo(o1+o2); 
        });
        // 정답 넣을 ans
        String ans = "";
        // 정답 넣기
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];
        // 첫글자가 0이라면 return 0
        if(ans.charAt(0) == '0')
            return "0";
        return  ans;
    }
}