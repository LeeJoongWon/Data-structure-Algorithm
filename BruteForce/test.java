package Test;
import java.util.Arrays;
import java.util.Comparator;

public class test {
	
	  static int bfMatch(String txt, String pat) {
	        int pt = 0;        // txt 커서
	        int pp = 0;        // pat 커서

	        while (pt != txt.length() && pp != pat.length()) {
	            if (txt.charAt(pt) == pat.charAt(pp)) {
	                pt++;
	                pp++;
	            } else {
	                pt = pt - pp + 1;
	                pp = 0;
	            }
	        }
	        if (pp == pat.length())        // 검색 성공
	            return pt - pp;
	        return -1;                     // 검색 실패
	    }

    public static void main(String[] args) {
    	  
 
          String s1 = "가나다라마바사";                // 텍스트용 문자열

          String s2 = "나다라";                   // 패턴용 문자열

          int idx = bfMatch(s1, s2);    // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색

          if (idx == -1)
              System.out.println("패턴이 없습니다.");
          else {
              System.out.println((idx + 1) + "번째 문자부터 일치합니다.");  
          }
    }  
}













