public class Queue<T>{
	private int max;	//ť�� �뷮
	private int front;	//ù��° ���
	private int rear;	//������ ���
	private int num;	//���� ������ ��
	private T[] queue;	//ť ��ü
	
	//ť�� �������
	public static class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	//ť�� ���� ��
	public static class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}
	
	public Queue(int capacity){
		
		num = front = rear = 0; //��� 0���� �ʱ�ȭ
		max = capacity;
		
		try {
			queue = (T[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
		
	}
	
	public void enque(T x) throws OverflowQueueException {
		
		if (num >= max)
			throw new OverflowQueueException(); // ť�� ���� ��
		
		queue[rear++] = x;
		num++;
		
		if (rear == max)
			rear = 0;
		
	}

	// ť���� �����͸� ��ť
	public T deque() throws EmptyQueueException {
		
		if (num <= 0)
			throw new EmptyQueueException(); // ť�� ��� ����
		
		T x = queue[front++];
		num--;
		
		if (front == max)
			front = 0;
		
		return x;
	}

	
	public T peek() throws EmptyQueueException {
		
		if(num <= 0) {
			throw new EmptyQueueException();
		}
			
		return queue[front];
	}
	
	
	public int indexOf(T x) {
		
		for(int i=0; i<num; i++) {
			int idx = (i + front) % max;
			if(queue[idx] == x) {
				return idx;
			}
		}
		
		return -1;
	}
	
	public void clear() {
		num = front = rear = 0;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return num;
	}
	
	public boolean isEmpty() {
		return num <= 0;
	}
	
	public boolean isFull() {
		return num >= max;
	}
	
	public void dump() {
		if(num <= 0) {
			System.out.println("ť�� ����ֽ��ϴ�");
		}else {
			for(int i = 0; i < num; i++) {
				System.out.println(queue[(i + front) % max]);
			}
		}
	}
	
}
