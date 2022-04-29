public class Stack <T> {
	private int max;	//스택 용량
	private int ptr;	//스택 포인터
	private T[] stk;	//스택 본체
	
	// 실행할 때 예외：스택이 비어 있음
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {
		}
	}

	// 실행할 때 예외：스택이 가득 참
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
	
	//데이터를 푸시
	public T push(T x) throws OverflowGstackException {
		if(ptr >= max) {	//스택이 가득 찼을경우
			throw new OverflowGstackException();
		}
		return stk[ptr++] = x;
	}
	
	//데이터를 꺼냄
	public T pop() throws EmptyGstackException{
		if(ptr <= 0) {	//스택이 비었을 경우
			throw new EmptyGstackException();
		}
		return stk[--ptr];
	}
	
	//데이터를 피크
	public T peek() throws EmptyGstackException{
		if(ptr <= 0) {
			throw new EmptyGstackException();
		}
		return stk[ptr - 1];
	}
	
	//검색
	public int indexOf(T x) {		
		for(int i = ptr-1; i>=0; i--) {
			
			if(stk[i].equals(x)) {
				return i;
			}
		}
		return -1;		
	}
	
	// 스택 안의 데이터를 바닥→꼭대기의 차례로 출력함
	public void dump() {
		if (ptr <= 0) {
			System.out.println("스택이 비었습니다.");
		}else {
			for (int i = 0; i < ptr; i++) {
				System.out.println(stk[i] + " ");
			}	
		}
	}
	
	// 스택을 비움
	public void clear() {
		ptr = 0;
	}

	// 스택의 용량을 반환
	public int capacity() {
		return max;
	}

	// 스택에 쌓여있는 데이터 수를 반환
	public int size() {
		return ptr;
	}

	// 스택이 비어 있는가?
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// 스택이 가득 찼는가?
	public boolean isFull() {
		return ptr >= max;
	}
	
	
	
}
