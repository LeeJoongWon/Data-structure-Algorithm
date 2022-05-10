package Test;

public class test {
	public static void main(String[] args) {
		int[] list = {6,4,8,3,1,9,7};
		
		for(int i=0; i<list.length; i++) {		
			int j;
			int tmp = list[i];
			
			for(j=i; j>0 && list[j-1]>tmp; j--) {
				list[j] = list[j-1];
			}
			
			list[j] = tmp;			
		}
		
		for(int i=0; i<list.length;i++) {
			System.out.print(list[i]);
		}
		
	}
}

















