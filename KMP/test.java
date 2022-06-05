package Test;
import java.util.Arrays;
import java.util.Comparator;

import com.sun.tools.classfile.Annotation.element_value_pair;

public class test {
	
	  static int kmpMatch(String txt, String pat) {
		  
	        int pt = 1;        // txt 커서
	        int pp = 0;        // pat 커서
	        int[] skip = new int[pat.length()+1];
	        
	        //pat 문자열중 반복되는 문자를 표로 만듬
	        while(pt != pat.length()) {
	        	
	        	if(pat.charAt(pt) == pat.charAt(pp)) {
	        		skip[++pt] = ++pp;
	        	} else if (pp == 0) {
					skip[++pt] = pp;
				} else {
					pp = skip[pp];
				}
	        	
	        }
	        
	        pt = pp = 0;
	        
	        //검색
	        while(pt != txt.length() && pp != pat.length()) {
	        	
	        	if(txt.charAt(pt) == pat.charAt(pp)) {
	        		pt++;
	        		pp++;
	        	} else if (pp == 0) {
					pt++;
				} else {
					pp = skip[pp];	//중복되는 문자열 패턴만큼 생략
				}
	        	
	        }
	        
            if(pp == pat.length()) {
            	return pt - pp;
            }
            
            return -1;
	    }

    public static void main(String[] args) {
    	  
 
          String s1 = "zabcabcabd";                // 텍스트용 문자열

          String s2 = "abcabd";                   // 패턴용 문자열

          int idx = kmpMatch(s1, s2);  

          if (idx == -1)
              System.out.println("패턴이 없습니다.");
          else {
              System.out.println((idx + 1) + "번째 문자부터 일치합니다.");  
          }
    }  
}













