package Test;
import java.util.Arrays;
import java.util.Comparator;

public class test {
	
	static void countingSort(int[] a, int n, int min, int max) {
		int[] f = new int[max - min + 2];		// 누적도수
		int[] b = new int[n];					// 작업용 목표 배열 

		for (int i=0;   i < n;         i++)   f[a[i]-min]++;					// 도수분포표 만들기
		for (int i=1;   i <= max-min+1; i++)   f[i] += f[i - 1];				// 누적도수분포표 만들기
		for (int i=n-1; i >= 0;         i--)   b[--f[a[i]-min]] = a[i];			// 목적 배열 만들기
		for (int i=0;   i < n;         i++)   a[i] = b[i];						// 배열 복사하기
		
	}
   
    public static void main(String[] args) {
        
        int[] x = {1,5,3,4,5,6,200};
   
		int max = x[0];
		for (int i = 1; i < x.length; i++)
			if (x[i] > max) max = x[i];

		int min = x[0];
		for (int i = 1; i < x.length; i++)
			if (x[i] < min) min = x[i];

		countingSort(x, x.length, min, max);	// 배열 x를 도수 정렬
		
		System.out.println("오름차순으로 정렬하였습니다.");
		for (int i = 0; i < x.length; i++)
			System.out.println("x[" + i + "]＝" + x[i]);
	}
}













