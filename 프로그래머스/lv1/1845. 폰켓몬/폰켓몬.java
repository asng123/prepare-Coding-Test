import java.util.*;
import java.io.*;

// HashSet
// add, addAll, contains, containsAll, isEmpty, remove, removeAll, size, toArray
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // HashSet 선언
        
        for(int i = 0; i< nums.length; i++) // nums를 순회하며
            set.add(nums[i]);               // 중복제거를 위해 set에 넣어준다
        
        if(set.size() >= nums.length/2) // 중복제거된 것이 절반보다 클때 최대값 가지고
            return nums.length/2;
        else                            // 그게 아니라면 최대 set.size()만큼 가진다
           return set.size();        
    }
}
