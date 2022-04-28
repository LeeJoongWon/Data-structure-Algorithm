
public class binarySearch {
	
	static int binSearch(int[]a, int key) {
		int pl = 0;					//검색 범위의 첫 인덱스
		int pr = a.length -1;		//검색 범위의 끝 인덱스
		
		
		do {
			
			int pc = (pl+pr) / 2;	//중앙 요소의 인덱스
			
			if(a[pc] == key) {
				return pc;
			} else if(a[pc] < key) {
				pl = pc +1;			//검색범위를 뒷쪽 절반으로 좁힘
			} else {
				pr = pc -1;			//검색범위를 앞쪽 절반으로 좁힘
			}
			
		}while(pl <= pr);
		
		return -1;					//검색실패
	}

	public static void main(String[] args) {
		

		int[] a = {1,2,3,4,5};
		int b;
		
		b = binSearch(a,3);
		
		if(b == -1) {
			System.out.println("요소에 값이 없습니다");
		}else {
			System.out.println("key값은 x["+b+"]에 있습니다");
			
		}
	}

}
