package Test;


public class test {
	static int[] buff;
	
	static void MergeSort(int[] a) {
		buff = new int[a.length];
		__MergeSort(a, 0, a.length-1);
		buff = null;
	}
	
	static void __MergeSort(int[] a, int left, int right) {
		if(left < right) {
			int i;
            int p = 0;
            int j = 0;
            int k = left;
			int center = (left+right)/2;
			
			__MergeSort(a, left, center);
			__MergeSort(a, center+1, right);
			
			for (i = left; i <= center; i++)
	              buff[p++] = a[i];

	        while (i <= right && j < p)
	              a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

	        while (j < p)
	              a[k++] = buff[j++];
	            
		}
	}
	

	public static void main(String[] args) {
		int[] list = {1,8,7,4,5,2,6,3,9};
		MergeSort(list);
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
}













