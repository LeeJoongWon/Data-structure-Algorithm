package Linked_List;
import Linked_List.LinkedList.Node;

public class test {

	public static void main(String[] args) {
			
//�ڵ� �׽�Ʈ
		Runtime.getRuntime().gc();
		long sTime = System.currentTimeMillis();
		
		try {
			
			LinkedList A = new LinkedList();
			A.append(7);
			A.append(2);
			A.append(8);
			A.append(5);
			A.append(3);
			A.append(4);
			A.print();
			
//			//���� n�� ����
//			A.delete(2);	
//			A.print();
//			System.out.println("------------------");
//			
//			//�߰������ n��° �ε��� ����
//			A.deleteIndex(A.get(4));
//			A.print();
//			System.out.println("------------------");
			
			//n�� �������� �������ڴ� ���� ū ���ڴ� ���������� ������
			Node n = partition2(A.get(1), 5);
			while(n.next != null) {
				System.out.print(n.data + " -> ");
				n = n.next;
			}
			System.out.println(n.data);
			
			
			} catch (Exception e) { 
				e.printStackTrace(); 
		} 
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("���� �޸� --- " + used + " bytes");
		Double sec = (System.currentTimeMillis() - sTime) / 1000.0;
		System.out.printf("�ҿ�ð� --- (%.2f��)%n", sec);
		
		
	}
	
	//4������ ��Ƽ��
	 static Node partition1(Node n, int x) {
	    	
	    	Node start1 = null; 
	    	Node end1 = null;
	    	Node start2 = null;
	    	Node end2 = null;
	    	
	    	while(n != null) {
	    		
	    		Node next = n.next; //���� ����� ��ġ�� ���� ����
	    		n.next = null; // n���� �ʿ��ϱ� ������ n�� ����� ���� �����ʹ� ����
	    		

         

	    		
	    		
	    		if(n.data < x) {
	    			
	    			if(start1 == null) {
	    				start1 = n;
	    				end1 = start1;
	    			}else {
	    				end1.next = n;
	    				end1 = n;
	    			}
	    			
	    		}else {
	    			
	    			if(start2 == null) {
	    				start2 = n;
	    				end2 = start2;
	    			}else {
	    				end2.next = n;
	    				end2 = n;
	    			}
	    			
	    		}
	    		
	    	      
	    		
	    		n = next;
	    		
	    	}
	    	
	    	if(start1 == null) {
	    		return start2;
	    	}
	    	
	    	end1.next = start2;
	    	return start1;
	    	
	    }
	 
	//4������ ��Ƽ�� ���� ---> 2������
	 static Node partition2(Node n, int x) {
		 
		 Node head = n;
		 Node tail = n;
		 
		 while(n != null) {
			 
			 Node next = n.next;
			 
			 if(n.data < x ) {
				n.next = head; 
				head = n;
			 }else {
				 tail.next = n;
				 tail = n;
			 }
			 
			 n = next;
			 
		 }
		 
		 tail.next = null;
		 return head;
	 }
	 
}
