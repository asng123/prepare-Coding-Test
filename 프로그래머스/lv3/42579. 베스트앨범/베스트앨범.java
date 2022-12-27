import java.util.*;
import java.io.*;

class Solution {
    public ArrayList solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> cnt = new HashMap<>();  // 장르별 총 횟수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
        
        for(int i=0;i<genres.length;i++){
            cnt.put(genres[i],cnt.getOrDefault(genres[i],0)+plays[i]);
            if(music.containsKey(genres[i])){
                music.get(genres[i]).put(i, plays[i]);
            }else{
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
            }
        }
        
        List<String> keySet = new ArrayList<>(cnt.keySet());
        keySet.sort((o1, o2) -> cnt.get(o2).compareTo(cnt.get(o1)));
        
        for(int i=0; i<keySet.size(); i++){
            String genre = keySet.get(i);
            
            HashMap<Integer, Integer> map = music.get(genre);
            
            List<Integer> keySet2 = new ArrayList<>(map.keySet());
            keySet2.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
            
            answer.add(keySet2.get(0));
            if(keySet2.size()>1)
                answer.add(keySet2.get(1));
        }
        
        
        return answer;
    }
}