import java.util.Scanner;

public class StackTester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack stack = new Stack<String>(4);
		
		while(true) {
			String s;
			System.out.println("현재 데이터 수:" + stack.size() +"/"+stack.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료:");
			
			int menu = scanner.nextInt();
			
			if(menu == 0) break;
			
		
			
			switch (menu) {
			
			case 1:
				System.out.print("데이터:");
				s = scanner.next();
				try {
					stack.push(s);
				} catch (Stack.OverflowGstackException e) {
					System.out.println("스택이 가득 찼습니다");
				}
				break;

			case 2:
				try {
					s = (String)stack.pop();
					System.out.println("팝 한 데이터는 "+s);
				} catch (Stack.EmptyGstackException e) {
					System.out.println("스택이 비어있습니다");
				}
				break;
				
			case 3:
				try {
					s = (String)stack.peek();
					System.out.println("피크 한 데이터는 "+s);
				} catch (Stack.EmptyGstackException e) {
					System.out.println("스택이 비어있습니다");
				}
				break;
				
			case 4:
				stack.dump();
				break;
				
			}
			
		}
		
	}
	
}
