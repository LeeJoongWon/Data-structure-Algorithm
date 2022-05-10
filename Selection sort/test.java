package Test;


public class test {

	public static void main(String[] args) {
		int min, temp;
		int[] list = {6,4,8,3,1,9,7};
		
		for(int i=0; i<list.length-1; i++) {
			min = i;
			for(int j=i+1;j<list.length;j++) {
				if(list[j]<list[min]) {
					min = j;
				}
			}
			temp = list[min];
		    list[min] = list[i];
		    list[i] = temp;
		}
		
		for(int i=0; i<list.length;i++) {
			System.out.print(list[i]);
		}
		
	}
}

















