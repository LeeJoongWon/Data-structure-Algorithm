import java.util.Scanner;

public class StackTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack stack = new Stack<String>(4);
		
		while(true) {
			String s;
			System.out.println("���� ������ ��:" + stack.size() +"/"+stack.capacity());
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (0)����:");
			
			int menu = scanner.nextInt();
			
			if(menu == 0) break;
			
		
			
			switch (menu) {
			
			case 1:
				System.out.print("������:");
				s = scanner.next();
				try {
					stack.push(s);
				} catch (Stack.OverflowGstackException e) {
					System.out.println("������ ���� á���ϴ�");
				}
				break;

			case 2:
				try {
					s = (String)stack.pop();
					System.out.println("�� �� �����ʹ� "+s);
				} catch (Stack.EmptyGstackException e) {
					System.out.println("������ ����ֽ��ϴ�");
				}
				break;
				
			case 3:
				try {
					s = (String)stack.peek();
					System.out.println("��ũ �� �����ʹ� "+s);
				} catch (Stack.EmptyGstackException e) {
					System.out.println("������ ����ֽ��ϴ�");
				}
				break;
				
			case 4:
				stack.dump();
				break;
				
			}
			
		}
		
	}
	
}
