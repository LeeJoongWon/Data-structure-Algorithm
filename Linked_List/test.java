package Linked_List;
import Linked_List.LinkedList.Node;

public class test {

	public static void main(String[] args) {
			
//코드 테스트
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
			
//			//정수 n값 삭제
//			A.delete(2);	
//			A.print();
//			System.out.println("------------------");
//			
//			//중간노드중 n번째 인덱스 삭제
//			A.deleteIndex(A.get(4));
//			A.print();
//			System.out.println("------------------");
			
			//n값 기준으로 작은숫자는 왼쪽 큰 숫자는 오른쪽으로 나누기
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
		System.out.println("사용된 메모리 --- " + used + " bytes");
		Double sec = (System.currentTimeMillis() - sTime) / 1000.0;
		System.out.printf("소요시간 --- (%.2f초)%n", sec);
		
		
	}
	
	//4포인터 파티션
	 static Node partition1(Node n, int x) {
	    	
	    	Node start1 = null; 
	    	Node end1 = null;
	    	Node start2 = null;
	    	Node end2 = null;
	    	
	    	while(n != null) {
	    		
	    		Node next = n.next; //다음 노드의 위치를 따로 저장
	    		n.next = null; // n값만 필요하기 떄문에 n에 연결된 다음 데이터는 삭제
	    		

         

	    		
	    		
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
	 
	//4포인터 파티션 개선 ---> 2포인터
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
