import java.util.Scanner;

public class QueueTester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue queue = new Queue<String>(4);
		
		while(true) {
			String s;
			System.out.println("���� ������ ��:" + queue.size() +"/"+queue.capacity());
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (0)����:");
			
			int menu = scanner.nextInt();
			
			if(menu == 0) break;
			
			switch (menu) {
			
			case 1:
				System.out.print("������:");
				s = scanner.next();
				try {
					queue.enque(s);
				} catch (Queue.OverflowQueueException e) {
					System.out.println("ť�� ���� á���ϴ�");
				}
				break;

			case 2:
				try {
					s = (String)queue.deque();
					System.out.println("��ť �� �����ʹ� "+s);
				} catch (Queue.EmptyQueueException e) {
					System.out.println("ť�� ����ֽ��ϴ�");
				}
				break;
				
			case 3:
				try {
					s = (String)queue.peek();
					System.out.println("��ũ �� �����ʹ� "+s);
				} catch (Queue.EmptyQueueException e) {
					System.out.println("ť�� ����ֽ��ϴ�");
				}
				break;
				
			case 4:
				queue.dump();
				break;
				
			}

		}
	}
}
