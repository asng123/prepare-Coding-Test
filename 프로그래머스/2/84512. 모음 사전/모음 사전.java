import java.util.*;
import java.io.*;

class Solution {
    
    static char[] alpha = {'A','E','I','O','U'};
    static char[] words;
    static ArrayList<String> makedWord = new ArrayList<>();
        
    public int solution(String word) {
        for(int i = 1;i<= 5; i++){
            words = new char[i];
            makeWord(0, i);
        }
        
        Collections.sort(makedWord);
        return makedWord.indexOf(word) + 1;
    }
    
    public void makeWord(int cnt, int limit){
        if(cnt == limit){
            String str = "";
            for(int i =0; i<cnt; i++)
                str+=words[i];
            makedWord.add(str);
            return;
        }
        for(int i =0; i<5;i++){
            words[cnt] = alpha[i];
            makeWord(cnt+1,limit);
        }
    }
    
}