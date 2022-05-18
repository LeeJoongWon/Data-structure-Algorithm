package Test;

public class test {
	
	static void swap(int[] list, int a, int b) {
		int tmp = list[a];
		list[a] = list[b];
		list[b] = tmp;
	}
	
	static void partition(int[] list,int left,int right) {
		int pl = left;						//왼쪽 커서
		int pr = right;			//오른쪽 커서
		int n  = list[(pl+pr)/2];	//피벗
		
		do {
			while(list[pl] < n) pl++;
			while(list[pr] > n) pr--;
			if(pl <= pr) {
				swap(list, pl++, pr--);
			}
			
		} while (pl <= pr);
		
		if(left < pr) partition(list, left, pr);
		if(pl < right) partition(list, pl, right);
	}
	
	public static void main(String[] args) {
		int[] list = {1,8,7,4,5,2,6,3,9};
		
		partition(list,0,list.length-1);
		
		for(int i=0; i<list.length; i++) {
			System.out.printf("%2d",list[i]);
		}
	}
}

















