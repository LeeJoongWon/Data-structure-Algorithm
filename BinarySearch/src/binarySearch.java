
public class binarySearch {
	
	static int binSearch(int[]a, int key) {
		int pl = 0;					//�˻� ������ ù �ε���
		int pr = a.length -1;		//�˻� ������ �� �ε���
		
		
		do {
			
			int pc = (pl+pr) / 2;	//�߾� ����� �ε���
			
			if(a[pc] == key) {
				return pc;
			} else if(a[pc] < key) {
				pl = pc +1;			//�˻������� ���� �������� ����
			} else {
				pr = pc -1;			//�˻������� ���� �������� ����
			}
			
		}while(pl <= pr);
		
		return -1;					//�˻�����
	}

	public static void main(String[] args) {
		

		int[] a = {1,2,3,4,5};
		int b;
		
		b = binSearch(a,3);
		
		if(b == -1) {
			System.out.println("��ҿ� ���� �����ϴ�");
		}else {
			System.out.println("key���� x["+b+"]�� �ֽ��ϴ�");
			
		}
	}

}
