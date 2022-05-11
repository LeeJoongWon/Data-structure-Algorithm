package Test;

public class test {
	
	static void shellSort(int[] list, int length) {
        int gap;
        /*
         * 셸 정렬에서 데이터를 나누는 값(이하 N)은 보통 전체에서 2로 나누는 값으로 진행한다. 
         * 그러나 3을 나누고 1을 더하는 경우가 더 빠르다고 알려져 있다. 
         * 즉 N/2 보다는 N/3+1이 더 빠르다.
         * */
        for (gap = 1; gap < length; gap = gap * 3 + 1)
            ;

        for ( ; gap > 0; gap /= 3) {
        	  for (int i = gap; i < length; i++) {
                int j;
                int tmp = list[i];
                for (j = i - gap; j >= 0 && list[j] > tmp; j -= gap) {
                	list[j + gap] = list[j];
                }
                list[j + gap] = tmp;
            }
        }   
    }
	
	public static void main(String[] args) {
		int[] list = {6,4,8,3,1,9,7};
		
		shellSort(list, list.length);
		
		for(int i=0; i<list.length;i++) {
			System.out.print(list[i]);
		}
		
	}
}

















