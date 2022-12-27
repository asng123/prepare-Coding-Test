import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // RT  CF  JM  AN
        // 01  23  45  67
        int[] score = new int[] {0,3,2,1,0,1,2,3};
        int[] type = new int[8];
        
        for(int i = 0; i<survey.length; i++){
            if(choices[i] == 4)
                continue;
            
            char jipyo = survey[i].charAt(0);
            
            switch(jipyo){
                case 'R':
                    if(choices[i]<4)    type[0] += score[choices[i]];
                    else    type[1] += score[choices[i]];
                    break;
                case 'T':
                    if(choices[i]<4)    type[1] += score[choices[i]];
                    else    type[0] += score[choices[i]];
                    break;
                case 'F':
                    if(choices[i]<4)    type[3] += score[choices[i]];
                    else    type[2] += score[choices[i]];
                    break;
                case 'C':
                    if(choices[i]<4)    type[2] += score[choices[i]];
                    else    type[3] += score[choices[i]];
                    break;
                case 'M':
                    if(choices[i]<4)    type[5] += score[choices[i]];
                    else    type[4] += score[choices[i]];
                    break;
                case 'J':
                    if(choices[i]<4)    type[4] += score[choices[i]];
                    else    type[5] += score[choices[i]];
                    break;
                case 'A':
                    if(choices[i]<4)    type[6] += score[choices[i]];
                    else   type[7] += score[choices[i]];
                    break;
                case 'N':
                    if(choices[i]<4)    type[7] += score[choices[i]];
                    else    type[6] += score[choices[i]];
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(type[0] == type[1])  sb.append('R');
        else if(type[0]>type[1])    sb.append('R');
        else    sb.append('T');
        
        if(type[2] == type[3])  sb.append('C');
        else if(type[2]>type[3])    sb.append('C');
        else    sb.append('F');
        
        if(type[4] == type[5])  sb.append('J');
        else if(type[4]>type[5])    sb.append('J');
        else    sb.append('M');
        
        if(type[6] == type[7])  sb.append('A');
        else if(type[6]>type[7])    sb.append('A');
        else    sb.append('N');
        
        answer = sb.toString();
        return answer;
    }
}