import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        
        //set은 add map은 put
        for(int i = 0; i< nums.length; i++){
            map.add(nums[i]);
        }
        
        //map의 사이즈가 폰켓몬수의 절반보다 크다면, 중복되지 않게 전부 챙길 수 있고
        if(map.size() >= nums.length/2)
            return nums.length/2;
        //그게 아니라면 최대 map.size만큼
        else
           return map.size();        
    }
}