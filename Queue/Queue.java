public class Queue<T>{
	private int max;	//큐의 용량
	private int front;	//첫번째 요소
	private int rear;	//마지막 요소
	private int num;	//현재 데이터 수
	private T[] queue;	//큐 본체
	
	//큐가 비어있음
	public static class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	//큐가 가득 참
	public static class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}
	
	public Queue(int capacity){
		
		num = front = rear = 0; //모두 0으로 초기화
		max = capacity;
		
		try {
			queue = (T[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
		
	}
	
	public void enque(T x) throws OverflowQueueException {
		
		if (num >= max)
			throw new OverflowQueueException(); // 큐가 가득 참
		
		queue[rear++] = x;
		num++;
		
		if (rear == max)
			rear = 0;
		
	}

	// 큐에서 데이터를 디큐
	public T deque() throws EmptyQueueException {
		
		if (num <= 0)
			throw new EmptyQueueException(); // 큐가 비어 있음
		
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
			System.out.println("큐가 비어있습니다");
		}else {
			for(int i = 0; i < num; i++) {
				System.out.println(queue[(i + front) % max]);
			}
		}
	}
	
}
