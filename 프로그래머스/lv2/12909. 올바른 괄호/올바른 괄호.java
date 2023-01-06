import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();    // 괄호가 올바른지 check할 stack
        for(int i = 0; i< s.length(); i++){     // s를 순회하면서
            if(s.charAt(i) == '('){             // '(' 열린괄호를 만나면 
                st.add(s.charAt(i));            // stack에 add
            }else{                              // ')' 닫힌괄호를 만나면
                if(st.size()>0)                 // stack에 열린괄호가 들어있다면
                    st.pop();                   // 짝이 맞으므로 pop하기
                else                            // stack에 열린괄호가 없다면
                    return false;               // 짝이 안맞아 올바르지 않으므로 false
            }
        }
        
        if(st.size()>0)                         // 닫히는 괄호가 없는데 열린괄호가 남았다면
            return false;                       // return false

        return true;                            // 완벽하게 끝났다면 return true
    }
}
