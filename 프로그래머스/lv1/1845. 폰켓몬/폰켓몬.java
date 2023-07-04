import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++)
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        
        if(map.size()>=n/2)
            return n/2;
        else
            return map.size();
        
    }
}