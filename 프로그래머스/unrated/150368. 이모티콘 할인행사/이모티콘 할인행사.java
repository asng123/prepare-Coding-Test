import java.util.*;
import java.io.*;

class Solution {
    
    static int[] discount, nums, answer;
    static int maxPlusUserCnt, maxSellPrice;
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        nums = new int[] {40,30,20,10};
        discount = new int[emoticons.length];
        
        makeDiscount(0, users, emoticons);
        
        return answer;
    }
    
    // 중복 순열로 이모티콘 할인율 구하기
    public static void makeDiscount(int cnt, int[][] users, int[] emoticons){
        if(cnt == emoticons.length){
            findAnswer(users,emoticons);
            return;
        }
        
        for(int i = 0; i<4; i++){
            discount[cnt] = nums[i];
            makeDiscount(cnt+1, users, emoticons);
        }
    }
    
    // 이모티콘 사용자가 최대로 많은
    // 올 40으로 시작해서 완탐
    public static void findAnswer(int[][] users, int[] emoticons){
        int plusUser = 0, totalVal = 0;
        int userCnt = users.length, emoticonCnt = emoticons.length;
        
        for(int i = 0; i<userCnt; i++){
            int sellVal = 0;
            for(int j = 0; j<emoticonCnt; j++){
                if(users[i][0] <= discount[j]){
                    sellVal += calculatePrice(emoticons[j], discount[j]);
                }
                if(sellVal >= users[i][1]){
                    sellVal = 0;
                    plusUser++;
                    break;
                }
            }

            totalVal += sellVal;
        }
        
        if(maxPlusUserCnt < plusUser){
            maxPlusUserCnt = plusUser;
            maxSellPrice = totalVal;
            answer[0] = plusUser;
            answer[1] = totalVal;
        } else if (maxPlusUserCnt == plusUser){
            if(maxSellPrice < totalVal){
                maxSellPrice = totalVal;
                answer[1] = totalVal;
            }
        }
    }
    
    public static int calculatePrice(int price, int discount){
        return (price - (price * discount / 100));
    }
    
}