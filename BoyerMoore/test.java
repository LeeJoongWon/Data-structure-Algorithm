package Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.sun.tools.classfile.Annotation.element_value_pair;

public class test {
	
	//--- 보이어-무어법으로 문자열 검색 ---//
    static int bmMatch(String txt, String pat) {
    	
        int txtLen = txt.length();        // txt의 문자 개수
        int patLen = pat.length();        // pat의 문자 개수
        
        if(patLen <= 0)	return -1;
        
        // skip 테이블 작성
        Map<Character, Integer> skip = new HashMap<>();
        for (int i = 0; i < txtLen; i++)
            skip.put(txt.charAt(i), -1);
        for (int i = 0; i < patLen; i++)
            skip.put(pat.charAt(i), i);
        
        // 검색
        int pt = patLen -1;	// txt를 따라가는 포인터
        int pp = patLen -1;	// pat를 따라가는 포인터
        
        while (pt < txtLen) {        	
            if(txt.charAt(pt) == pat.charAt(pp)) {
            	if(pp == 0) {	//검색 성공
            		return pt;	
            	}
            	pt--; pp--;
            }
            else {	// 포인터 이동
            	pt += patLen - Math.min(pp, 1 + skip.get(txt.charAt(pt)));	
				pp = patLen - 1;
			}

        }
        return -1;	// 검색 실패
    }

    public static void main(String[] args) {
    	  
 
          String s1 = "ABCXAABCDGSW";                // 텍스트용 문자열

          String s2 = "ABCD";                   // 패턴용 문자열

          int idx = bmMatch(s1, s2);  

          if (idx == -1)
              System.out.println("패턴이 없습니다.");
          else {
              System.out.println((idx + 1) + "번째 문자부터 일치합니다.");  
          }
    }  
}













