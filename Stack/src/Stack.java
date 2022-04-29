public class Stack <T> {
	private int max;	//���� �뷮
	private int ptr;	//���� ������
	private T[] stk;	//���� ��ü
	
	// ������ �� ���ܣ������� ��� ����
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {
		}
	}

	// ������ �� ���ܣ������� ���� ��
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
		}
	}
	
	public Stack(int stackSize) {
		ptr = 0;
		max = stackSize;
		try {
			stk = (T[]) new Object[stackSize];
		} catch (Exception e) {
			max = 0;
		}
	}
	
	//�����͸� Ǫ��
	public T push(T x) throws OverflowGstackException {
		if(ptr >= max) {	//������ ���� á�����
			throw new OverflowGstackException();
		}
		return stk[ptr++] = x;
	}
	
	//�����͸� ����
	public T pop() throws EmptyGstackException{
		if(ptr <= 0) {	//������ ����� ���
			throw new EmptyGstackException();
		}
		return stk[--ptr];
	}
	
	//�����͸� ��ũ
	public T peek() throws EmptyGstackException{
		if(ptr <= 0) {
			throw new EmptyGstackException();
		}
		return stk[ptr - 1];
	}
	
	//�˻�
	public int indexOf(T x) {		
		for(int i = ptr-1; i>=0; i--) {
			
			if(stk[i].equals(x)) {
				return i;
			}
		}
		return -1;		
	}
	
	// ���� ���� �����͸� �ٴڡ������� ���ʷ� �����
	public void dump() {
		if (ptr <= 0) {
			System.out.println("������ ������ϴ�.");
		}else {
			for (int i = 0; i < ptr; i++) {
				System.out.println(stk[i] + " ");
			}	
		}
	}
	
	// ������ ���
	public void clear() {
		ptr = 0;
	}

	// ������ �뷮�� ��ȯ
	public int capacity() {
		return max;
	}

	// ���ÿ� �׿��ִ� ������ ���� ��ȯ
	public int size() {
		return ptr;
	}

	// ������ ��� �ִ°�?
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// ������ ���� á�°�?
	public boolean isFull() {
		return ptr >= max;
	}
	
	
	
}
