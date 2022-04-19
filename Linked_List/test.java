package Linked_List;
import Linked_List.LinkedList.Node;

class Storage{
	int carry = 0;
	Node result = null;
	
}

public class test {

	public static void main(String[] args) {
			
//�ڵ� �׽�Ʈ
		Runtime.getRuntime().gc();
		long sTime = System.currentTimeMillis();
		
		try {
			
			/* ���� n�� ����*/
//			A.delete(2);	
//			A.print();
//			System.out.println("------------------");
			
			/* �߰������ n��° �ε��� ����*/
//			A.deleteIndex(A.get(4));
//			A.print();
//			System.out.println("------------------");
			
			/* n�� �������� �������ڴ� ���� ū ���ڴ� ���������� ������*/
//			Node n1 = partition2(l1.get(1), 5);
//			nodePrint(n1);
			
			/* 2���� ��带 ���Ͻÿ� */
//			LinkedList l1 = new LinkedList();
//			l1.append(9);
//			l1.append(1);
//			l1.print();
//			
//			LinkedList l2 = new LinkedList();
//			l2.append(1);
//			l2.append(1);
//			l2.print();
//		
//			Node n2 = sumLists(l1.get(1), l2.get(1), 0);
//			nodePrint(n2);
//			
//			Node n3 = sumLists2(l1.get(1), l2.get(1));
//			nodePrint(n3);
		
		
			} catch (Exception e) { 
				e.printStackTrace(); 
		} 
		
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("���� �޸� --- " + used + " bytes");
		Double sec = (System.currentTimeMillis() - sTime) / 1000.0;
		System.out.printf("�ҿ�ð� --- (%.2f��)%n", sec);
		
		
	}
	
	static void nodePrint(Node n) {
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
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
	 
	 
	 static Node sumLists(Node l1, Node l2, int carry) {
		 
		if(l1 == null && l2 == null && carry == 0) {
			return null;
		} 
		
		Node result = new Node();
		int value = carry;
		
		if(l1 != null) {
			value += l1.data;
		}
		
		if(l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		
		if(l1 != null || l2 != null) {
			Node next = sumLists(l1 == null? null : l1.next,
								  l2 == null? null : l2.next,
								  value >= 10? 1 : 0);
			result.next = next;
		}
		return result;
	 }
 
	 static Node sumLists2(Node l1, Node l2) {
		 int len1 = getNodeLength(l1);
		 int len2 = getNodeLength(l2);
		 
		 if(len1 < len2) {
			l1 = LPadList(l1, len2 - len1);
		 }else {
			l2 = LPadList(l2, len1 - len2);
		 }
		 Storage storage = addLists(l1, l2);
		 if(storage.carry != 0) {
			 storage.result = insertBefore(storage.result, storage.carry);
		 }
		 return storage.result;
	 }
	 
	 static Storage addLists(Node l1, Node l2) {
		 
		 if(l1 == null && l2 == null) {
			 Storage storage = new Storage();
			 return storage;
		 }
		 
		 Storage storage = addLists(l1.next, l2.next);
		 int value = storage.carry + l1.data + l2.data;
		 int data = value % 10;
		 storage.result = insertBefore(storage.result, data);
		 storage.carry = value / 10;
		 return storage;
	 }
	 
	 static int getNodeLength(Node n) {
		 
		int length = 0;
		
		while(n!= null) {
			length++;
			n = n.next;		
		}
		return length;	
	 }
	 
	 static Node insertBefore (Node node, int data) {
		 Node before = new Node(data);
		 if(node != null) {
			 before.next = node;
		 }
		 return before;
	 }
	 
	 static Node LPadList(Node n,int length) {
		 Node head = n;
		 for(int i =0; i< length; i++) {
			 head = insertBefore(head, 0);
		 }
		 return head;
	 }
}
