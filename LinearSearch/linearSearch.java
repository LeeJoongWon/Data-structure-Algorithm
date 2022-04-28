
public class linearSearch {
	
	static int seqSearch(int[] a, int key) {

		int searchSuccess = -1;
		
		for(int i=0; i<a.length; i++) {
			if(a[i] == key) {
				searchSuccess = i;
				return searchSuccess;
			}
		}
		
		return searchSuccess;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		int b;
		
		b = seqSearch(a,3);
		
		if(b == -1) {
			System.out.println("요소에 값이 없습니다");
		}else {
			System.out.println("key값은 x["+b+"]에 있습니다");
		}
		
	}
}
