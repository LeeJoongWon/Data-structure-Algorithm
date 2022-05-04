package Test;

public class test {

	//a와 b를 교환
	static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	/*
	 * 마지막으로 교환한 위치를 저장하여 정렬이 완료된 범위는 검색에서 생략
	 * */
    static void bubbleSort(int[] a, int size) {
        int k = 0;                               // a[k]보다 앞쪽은 정렬을 마침
        while (k < size - 1) {
            int last = size - 1;                    //마지막으로 교환이 발생한 인덱스 위치값을 저장(초기값은 배열 크기)
            for (int j = size - 1; j > k; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;	//교환이 발생하면 교환한 인덱스 위치값을 last에 저장
                }
            }      	
            k = last;	//k에 마지막으로 교환한 인덱스 위치값을 저장
        }
    }
	
	public static void main(String[] args) {
		
		int[] a = {6,4,3,7,1,9,8};
		bubbleSort(a,a.length); 		
		System.out.println("오름차순으로 정렬했습니다.");		
	    	for (int i = 0; i < a.length; i++) {
	    		System.out.println("x[" + i + "]=" + a[i]);
	    	
	    	}
	       	
	}
	
}

















