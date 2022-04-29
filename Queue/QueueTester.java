import java.util.Scanner;

public class QueueTester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue queue = new Queue<String>(4);
		
		while(true) {
			String s;
			System.out.println("현재 데이터 수:" + queue.size() +"/"+queue.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료:");
			
			int menu = scanner.nextInt();
			
			if(menu == 0) break;
			
			switch (menu) {
			
			case 1:
				System.out.print("데이터:");
				s = scanner.next();
				try {
					queue.enque(s);
				} catch (Queue.OverflowQueueException e) {
					System.out.println("큐가 가득 찼습니다");
				}
				break;

			case 2:
				try {
					s = (String)queue.deque();
					System.out.println("디큐 한 데이터는 "+s);
				} catch (Queue.EmptyQueueException e) {
					System.out.println("큐가 비어있습니다");
				}
				break;
				
			case 3:
				try {
					s = (String)queue.peek();
					System.out.println("피크 한 데이터는 "+s);
				} catch (Queue.EmptyQueueException e) {
					System.out.println("큐가 비어있습니다");
				}
				break;
				
			case 4:
				queue.dump();
				break;
				
			}

		}
	}
}
