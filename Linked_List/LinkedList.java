package Linked_List;

import Linked_List.LinkedList.Node;

class LinkedList{
	Node header;
	
	static class Node{	
		
		int data;
		Node next = null;	
		
		Node() {}
		Node(int data2) { this.data = data2; }
		
	}
	
	LinkedList(){
		header = new Node();	
	}
	
    void append(int d) {
    	
        Node end = new Node();
        end.data = d;
        Node n = header;
        
        while (n.next != null){
            n = n.next;
        }
        
        n.next = end;
    }
    
    void delete(int d){
    	
    	Node n = header;
    	
    	while(n.next != null) {
    		
    		if(n.next.data == d) {
    			n.next = n.next.next;
    		}else {
    			n = n.next;
    		}
    		
    	}
    	
    }
    
    void print() {
    	
    	Node n = header.next;
    	
    	if(n == null) {
    		return;
    	}
    	
    	while(n.next != null) {
    		System.out.print(n.data + " -> ");
    		n = n.next;
    	}
    	
    	System.out.println(n.data);
    	
    }
    
    void removeDups() {
    	
    	Node n = header;
    	
    	while (n != null && n.next != null) {
    		Node r = n;
    		
    		while (r.next != null) {
    			
    			if(n.data == r.next.data) {
    				r.next = r.next.next;
    			}else {
    				r = r.next;
    			}
    			
    		}
    		
    		n = n.next;
    	}
    	
    }
    
    Node get(int d) {
    	
    	Node n = header;
    	
    	for(int i=0; i<d; i++) {
    		n = n.next;
    	}
    	return n;
    	
    }
    
    void deleteIndex(Node n) {
    	
    	if(n == null || n.next == null) {
    		return;
    	}
    	
    	Node next = n.next;
    	n.data = next.data;
    	n.next = next.next;
    	
    }
    
    void reset() {
    	header = new Node(); 
    }
    
    
}